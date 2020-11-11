package com.baidu.android.imsdk.chatuser.request;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IpInfo;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.db.DBManager;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.MsgUtility;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class IMGetUserIpLocation extends Message {
    private static final String TAG = "IMGetUserIpLocation";
    private Context mContext;
    private ArrayList<Long> mUids;
    private int msgtype = 0;
    private int mReSendCount = 0;

    public IMGetUserIpLocation(Context context, ArrayList<Long> arrayList) {
        this.mContext = context;
        this.mUids = arrayList;
        initCommonParameter(context);
        setNeedReplay(true);
        setType(91);
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 91);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put("uk", this.mUk);
            jSONObject.put("to_users", MsgUtility.listToJsonArray(this.mUids));
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(TAG, "Exception ", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    public int getMsgType() {
        return this.msgtype;
    }

    public void setMsgtype(int i) {
        this.msgtype = i;
    }

    public static IMGetUserIpLocation newInstance(Context context, Intent intent) {
        ArrayList arrayList = (ArrayList) intent.getExtras().getSerializable(Constants.EXTRA_UIDS);
        int intExtra = intent.getIntExtra(Constants.EXTRA_SAVE_TO_DB, 0);
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        IMGetUserIpLocation iMGetUserIpLocation = new IMGetUserIpLocation(context, arrayList);
        iMGetUserIpLocation.setMsgtype(intExtra);
        JSONObject jSONObject = new JSONObject();
        if (intExtra == 1) {
            try {
                jSONObject.put("type", intExtra);
            } catch (JSONException e) {
                LogUtils.e(TAG, "Exception ", e);
                new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
            }
            saveCmdMessage(context, iMGetUserIpLocation, jSONObject.toString(), iMGetUserIpLocation.getPriority());
        }
        return iMGetUserIpLocation;
    }

    public ArrayList<Long> getToUsers() {
        return this.mUids;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        ArrayList<IpInfo> arrayList;
        ArrayList<IpInfo> arrayList2 = null;
        if (getMsgType() == 1) {
            if (i != 0) {
                if (this.mReSendCount >= 3) {
                    setNeedReSend(false);
                    DBManager.getInstance(context).deleteCmdMsg(getUUID());
                } else {
                    this.mReSendCount++;
                    setNeedReSend(true);
                    return;
                }
            } else {
                DBManager.getInstance(context).deleteCmdMsg(getUUID());
                setNeedReSend(false);
            }
        }
        if (i != 0) {
            arrayList = null;
        } else {
            try {
                if (jSONObject.has("location")) {
                    ArrayList<IpInfo> arrayList3 = new ArrayList<>();
                    try {
                        JSONArray jSONArray = (JSONArray) jSONObject.opt("location");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                            IpInfo ipInfo = new IpInfo();
                            ipInfo.setUid(jSONObject2.optLong("uid"));
                            ipInfo.setIp(jSONObject2.optString(TableDefine.UserInfoColumns.COLUMN_IP));
                            ipInfo.setIsp(jSONObject2.optString("isp"));
                            ipInfo.setCountry(jSONObject2.optString("country"));
                            ipInfo.setProv(jSONObject2.optString("prov"));
                            ipInfo.setCity(jSONObject2.optString("city"));
                            ipInfo.setCounty(jSONObject2.optString("county"));
                            arrayList3.add(ipInfo);
                        }
                        updateDB(context, arrayList3);
                        arrayList2 = arrayList3;
                    } catch (Exception e) {
                        arrayList2 = arrayList3;
                        e = e;
                        LogUtils.e(TAG, "IMGetUserIpLocation handleMessageResult :", e);
                        arrayList = arrayList2;
                        ChatUserManagerImpl.getInstance(context).onGetUserIpResult(context, getMsgType(), this.mListenerKey, i, str, this.mUids, arrayList);
                    }
                }
                arrayList = arrayList2;
            } catch (Exception e2) {
                e = e2;
            }
        }
        ChatUserManagerImpl.getInstance(context).onGetUserIpResult(context, getMsgType(), this.mListenerKey, i, str, this.mUids, arrayList);
    }

    private void updateDB(Context context, ArrayList<IpInfo> arrayList) {
        IMUserManager.getInstance(context).updateUserIpInfo(arrayList);
    }
}
