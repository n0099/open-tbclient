package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.IMessageReceiveListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ConfigMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class RetrieveMsgReceiver implements IMessageReceiveListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RetrieveMsgReceiver";
    public static volatile RetrieveMsgReceiver mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    public RetrieveMsgReceiver(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
    }

    public static RetrieveMsgReceiver getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (mInstance == null) {
                synchronized (RetrieveMsgReceiver.class) {
                    if (mInstance == null) {
                        mInstance = new RetrieveMsgReceiver(context);
                    }
                }
            }
            return mInstance;
        }
        return (RetrieveMsgReceiver) invokeL.objValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.IMessageReceiveListener
    public void onReceiveMessage(int i, int i2, ArrayList<ChatMsg> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, arrayList) == null) || i != 0 || arrayList == null || arrayList.size() <= 0) {
            return;
        }
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
                                for (int i3 = 0; i3 < length; i3++) {
                                    RetrieveTaskManager.getInstance(this.mContext).dispatch(jSONArray.optJSONObject(i3));
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
