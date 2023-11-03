package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.ac;
import com.baidu.tieba.ec;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class BdStatsItem {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String childType;
    public long logID;
    public ArrayList<BasicNameValuePair> mKvLists;
    public long mStartTime;
    public StringBuilder mStringBuilder;
    public ec mTrackLogInfo;
    public String mType;
    public String parentType;
    public long sequenceID;
    public boolean usedSequenceId;

    public BdStatsItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.logID = 1L;
        this.sequenceID = -1L;
        this.usedSequenceId = false;
        this.mType = null;
        this.mStringBuilder = new StringBuilder(100);
    }

    public BdStatsItem(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.logID = 1L;
        this.sequenceID = -1L;
        this.usedSequenceId = false;
        this.mType = null;
        this.mStringBuilder = new StringBuilder(100);
        this.mType = str;
        this.usedSequenceId = false;
        this.logID = -1L;
        this.sequenceID = -1L;
    }

    public String getValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            ArrayList<BasicNameValuePair> arrayList = this.mKvLists;
            if (arrayList != null && arrayList.size() != 0 && !TextUtils.isEmpty(str)) {
                Iterator<BasicNameValuePair> it = this.mKvLists.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if (next != null && next.getName() != null && next.getName().equals(str)) {
                        return next.getValue();
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String valueEscapeSpace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return str.replace(" ", "_").replace(PreferencesUtil.LEFT_MOUNT, "(").replace(PreferencesUtil.RIGHT_MOUNT, SmallTailInfo.EMOTION_SUFFIX).replace("&", "|");
        }
        return (String) invokeL.objValue;
    }

    public void addValue(Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, obj, obj2) == null) && obj != null && obj2 != null) {
            if (this.mKvLists == null) {
                this.mKvLists = new ArrayList<>();
            }
            this.mKvLists.add(new BasicNameValuePair(obj.toString(), obj2.toString()));
        }
    }

    public void append(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        if (this.mStringBuilder.length() > 0) {
            this.mStringBuilder.append('&');
        }
        this.mStringBuilder.append(str);
        this.mStringBuilder.append("=");
        try {
            this.mStringBuilder.append(URLEncoder.encode(valueEscapeSpace(str2), "utf-8"));
        } catch (Throwable th) {
            BdLog.e(th);
            this.mStringBuilder.append(valueEscapeSpace(str2));
        }
    }

    public void setValue(String str, int i) {
        ArrayList<BasicNameValuePair> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048587, this, str, i) == null) && (arrayList = this.mKvLists) != null && arrayList.size() != 0 && !TextUtils.isEmpty(str)) {
            BasicNameValuePair basicNameValuePair = null;
            Iterator<BasicNameValuePair> it = this.mKvLists.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BasicNameValuePair next = it.next();
                if (next != null && next.getName() != null && next.getName().equals(str)) {
                    basicNameValuePair = next;
                    break;
                }
            }
            if (basicNameValuePair == null) {
                return;
            }
            this.mKvLists.remove(basicNameValuePair);
            this.mKvLists.add(new BasicNameValuePair(str, String.valueOf(i)));
        }
    }

    public void append(Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr) != null) || objArr == null) {
            return;
        }
        for (int i = 0; i < objArr.length / 2; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            if (i3 < objArr.length) {
                addValue(objArr[i2], objArr[i3]);
            }
        }
    }

    public void setMStringBuilder(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mStringBuilder.append(str);
    }

    public void generateTrackLogInfo(ac acVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, acVar) == null) {
            if (this.mTrackLogInfo == null) {
                this.mTrackLogInfo = new ec();
            }
            this.mTrackLogInfo.f(acVar);
            ArrayList<BasicNameValuePair> arrayList = this.mKvLists;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<BasicNameValuePair> it = this.mKvLists.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if ("module".equals(next.getName())) {
                        this.mTrackLogInfo.i(next.getValue());
                    } else if ("st".equals(next.getName())) {
                        this.mTrackLogInfo.e(next.getValue());
                    } else if ("errNo".equals(next.getName())) {
                        this.mTrackLogInfo.g(next.getValue());
                    } else if (StatConstants.KEY_EXT_ERR_MSG.equals(next.getName())) {
                        this.mTrackLogInfo.h(next.getValue());
                    } else {
                        this.mTrackLogInfo.b(next.getName(), next.getValue());
                    }
                }
            }
            StringBuilder sb = this.mStringBuilder;
            if (sb != null) {
                this.mTrackLogInfo.a(sb.toString());
            }
        }
    }

    public ArrayList<BasicNameValuePair> getKvList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mKvLists;
        }
        return (ArrayList) invokeV.objValue;
    }

    public long getTimeCost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return System.currentTimeMillis() - this.mStartTime;
        }
        return invokeV.longValue;
    }

    public ec getTrackLogInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mTrackLogInfo;
        }
        return (ec) invokeV.objValue;
    }

    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mType;
        }
        return (String) invokeV.objValue;
    }

    public void startTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mStartTime = System.currentTimeMillis();
        }
    }

    public void parse(String str) {
        String[] split;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mKvLists == null) {
            this.mKvLists = new ArrayList<>();
        }
        this.mKvLists.clear();
        String[] split2 = str.split("&");
        if (split2 != null && split2.length != 0) {
            for (String str2 : split2) {
                if (!TextUtils.isEmpty(str2) && (split = str2.split("=")) != null && split.length == 2) {
                    try {
                        this.mKvLists.add(new BasicNameValuePair(split[0], URLDecoder.decode(split[1], "utf-8")));
                    } catch (UnsupportedEncodingException e) {
                        BdLog.e(e);
                    }
                }
            }
        }
    }

    public JSONObject toJSONObject() {
        InterceptResult invokeV;
        String[] split;
        String[] split2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (this.mStringBuilder.length() > 0 && (split = this.mStringBuilder.toString().split("&")) != null && split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && (split2 = str.split("=")) != null && split2.length == 2) {
                        try {
                            jSONObject.put(split2[0], URLDecoder.decode(split2[1], "utf-8"));
                        } catch (UnsupportedEncodingException | JSONException e) {
                            BdLog.e(e);
                        }
                    }
                }
            }
            ArrayList<BasicNameValuePair> arrayList = this.mKvLists;
            if (arrayList != null) {
                Iterator<BasicNameValuePair> it = arrayList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                        try {
                            jSONObject.put(next.getName(), URLEncoder.encode(valueEscapeSpace(next.getValue()), "utf-8"));
                        } catch (UnsupportedEncodingException | JSONException e2) {
                            BdLog.e(e2);
                        }
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            StringBuilder sb = new StringBuilder(200);
            if (this.mStringBuilder.length() > 0) {
                sb.append((CharSequence) this.mStringBuilder);
            }
            ArrayList<BasicNameValuePair> arrayList = this.mKvLists;
            if (arrayList != null) {
                Iterator<BasicNameValuePair> it = arrayList.iterator();
                while (it.hasNext()) {
                    BasicNameValuePair next = it.next();
                    if (!TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                        if (sb.length() > 0) {
                            sb.append('&');
                        }
                        sb.append(next.getName());
                        sb.append('=');
                        try {
                            sb.append(URLEncoder.encode(valueEscapeSpace(next.getValue()), "utf-8"));
                        } catch (UnsupportedEncodingException e) {
                            BdLog.e(e);
                            sb.append(valueEscapeSpace(next.getValue()));
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
