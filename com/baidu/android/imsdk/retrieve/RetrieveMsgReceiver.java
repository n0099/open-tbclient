package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.IMessageReceiveListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ConfigMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class RetrieveMsgReceiver implements IMessageReceiveListener {
    public static final String TAG = "RetrieveMsgReceiver";
    public static volatile RetrieveMsgReceiver mInstance;
    public Context mContext;

    public RetrieveMsgReceiver(Context context) {
        this.mContext = context;
    }

    public static RetrieveMsgReceiver getInstance(Context context) {
        if (mInstance == null) {
            synchronized (RetrieveMsgReceiver.class) {
                if (mInstance == null) {
                    mInstance = new RetrieveMsgReceiver(context);
                }
            }
        }
        return mInstance;
    }

    @Override // com.baidu.android.imsdk.chatmessage.IMessageReceiveListener
    public void onReceiveMessage(int i2, int i3, ArrayList<ChatMsg> arrayList) {
        if (i2 == 0 && arrayList != null && arrayList.size() > 0) {
            synchronized (this) {
                Iterator<ChatMsg> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatMsg next = it.next();
                    LogUtils.d(TAG, "retrieve-->msg type is:" + next.getMsgType());
                    if (next.getMsgType() == 20 && (next instanceof ConfigMsg)) {
                        String dataList = ((ConfigMsg) next).getDataList();
                        LogUtils.d(TAG, "retrieve-->retrieve config msg:" + dataList);
                        if (!TextUtils.isEmpty(dataList)) {
                            try {
                                JSONArray jSONArray = new JSONArray(dataList);
                                if (jSONArray.length() > 0) {
                                    int length = jSONArray.length();
                                    for (int i4 = 0; i4 < length; i4++) {
                                        RetrieveTaskManager.getInstance(this.mContext).dispatch(jSONArray.optJSONObject(i4));
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
