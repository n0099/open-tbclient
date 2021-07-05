package com.baidu.android.imsdk.chatmessage.sync;

import android.content.Context;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes.dex */
public class SyncGroupMessageService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_MAP_SIZE = 1;
    public static final String TAG = "SyncGroupMessageService";
    public static SyncGroupMessageService mInstance;
    public static Object synobject;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mComplete;
    public ConcurrentLinkedQueue<DialogRecord> mDialogRecords;
    public Map<ChatObject, SyncGroupMessage> mGroupSyncMap;
    public ConcurrentLinkedQueue<DialogRecord> mNewRecords;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1709780970, "Lcom/baidu/android/imsdk/chatmessage/sync/SyncGroupMessageService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1709780970, "Lcom/baidu/android/imsdk/chatmessage/sync/SyncGroupMessageService;");
                return;
            }
        }
        synobject = new Object();
    }

    public SyncGroupMessageService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mComplete = true;
        this.mGroupSyncMap = new ConcurrentHashMap();
        this.mDialogRecords = new ConcurrentLinkedQueue<>();
        this.mNewRecords = new ConcurrentLinkedQueue<>();
    }

    private DialogRecord get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) ? this.mDialogRecords.peek() : (DialogRecord) invokeV.objValue;
    }

    public static SyncGroupMessageService getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            synchronized (synobject) {
                if (mInstance == null) {
                    mInstance = new SyncGroupMessageService();
                }
            }
            return mInstance;
        }
        return (SyncGroupMessageService) invokeV.objValue;
    }

    private DialogRecord getNew() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            LogUtils.d(TAG, "get new dialogRecord ");
            return this.mNewRecords.peek();
        }
        return (DialogRecord) invokeV.objValue;
    }

    private void put(DialogRecord dialogRecord) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, this, dialogRecord) == null) || dialogRecord == null) {
            return;
        }
        String str = TAG;
        LogUtils.d(str, "put dialogRecord " + dialogRecord.getContacter());
        boolean z = false;
        Iterator<DialogRecord> it = this.mDialogRecords.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DialogRecord next = it.next();
            if (next.getCategory() == dialogRecord.getCategory() && next.getContacter() == dialogRecord.getContacter()) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        this.mDialogRecords.add(dialogRecord);
    }

    private void putNew(DialogRecord dialogRecord) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, dialogRecord) == null) || dialogRecord == null) {
            return;
        }
        String str = TAG;
        LogUtils.d(str, "put new dialogRecord " + dialogRecord.getContacter());
        boolean z = false;
        Iterator<DialogRecord> it = this.mNewRecords.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DialogRecord next = it.next();
            if (next.getCategory() == dialogRecord.getCategory() && next.getContacter() == dialogRecord.getContacter()) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        this.mNewRecords.add(dialogRecord);
    }

    private void remove(DialogRecord dialogRecord, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, this, dialogRecord, i2) == null) {
            String str = TAG;
            LogUtils.d(str, "BB remove dialogRecord " + dialogRecord + " " + i2);
            if (i2 == 0) {
                this.mDialogRecords.remove(dialogRecord);
            } else {
                this.mNewRecords.remove(dialogRecord);
            }
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LogUtils.d(TAG, "BB clear");
            this.mDialogRecords.clear();
            Map<ChatObject, SyncGroupMessage> map = this.mGroupSyncMap;
            if (map != null) {
                map.clear();
            }
        }
    }

    public void execute(Context context, int i2, long j, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            String str = TAG;
            LogUtils.d(str, "SYNCGROUPNEW group sync execute 1 \"to\":" + j + " " + j2 + " " + i3);
            synchronized (synobject) {
                DialogRecord dialogRecord = DialogRecordDBManager.getInstance(context).getDialogRecord(i2, j);
                if (dialogRecord == null) {
                    dialogRecord = new DialogRecord().setCategory(i2).setContacter(j).setJumpToRecent(0).setMaxMsgid(0L).setUpdateTime(System.currentTimeMillis());
                    long add = DialogRecordDBManager.getInstance(context).add(dialogRecord);
                    dialogRecord.setJumpToRecent(1);
                    String str2 = TAG;
                    LogUtils.d(str2, "SYNCGROUPNEW " + dialogRecord.toString());
                    if (add < 0) {
                        String str3 = TAG;
                        LogUtils.e(str3, "SYNCGROUPNEW add dialogRecord err " + add);
                        return;
                    }
                } else if (dialogRecord.getMaxMsgid() <= 0) {
                    dialogRecord.setJumpToRecent(1);
                } else {
                    dialogRecord.setJumpToRecent(0);
                }
                dialogRecord.setState(0);
                putNew(dialogRecord);
                execute(context, dialogRecord, i3);
            }
        }
    }

    public ChatObject getChatObject(Context context, DialogRecord dialogRecord) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, dialogRecord)) == null) ? new ChatObject(context, dialogRecord.getCategory(), dialogRecord.getContacter()) : (ChatObject) invokeLL.objValue;
    }

    public int getState(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            int i2 = DialogRecordDBManager.getInstance(context).getUnCompleteItemCount() > 0 ? 0 : 1;
            if (i2 == 0 && this.mComplete) {
                return 1;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mComplete : invokeV.booleanValue;
    }

    public int getState(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, context, j)) == null) {
            String str = TAG;
            LogUtils.d(str, "getState --->" + j);
            return (DialogRecordDBManager.getInstance(context).getUnCompleteItemCount(j) == 0 || this.mComplete) ? 1 : 0;
        }
        return invokeLJ.intValue;
    }

    public void execute(Context context, DialogRecord dialogRecord, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, context, dialogRecord, i2) == null) {
            int i3 = 0;
            if (i2 == 0) {
                this.mComplete = false;
            }
            synchronized (synobject) {
                if (dialogRecord != null && i2 == 0) {
                    if (dialogRecord.getMaxMsgid() == 0) {
                        dialogRecord.setJumpToRecent(1);
                    }
                    put(dialogRecord);
                }
                DialogRecord dialogRecord2 = get();
                if (dialogRecord2 == null) {
                    LogUtils.d(TAG, "SYNCGROUP loging trigger dialog is null --1");
                    dialogRecord2 = getNew();
                    if (dialogRecord2 != null) {
                        LogUtils.d(TAG, "SYNCGROUPNEW to work...");
                        i2 = 2;
                        i3 = 1;
                    }
                } else {
                    i2 = 0;
                }
                if (dialogRecord2 == null) {
                    LogUtils.d(TAG, "SYNCGROUP loging trigger dialog is null --2");
                    return;
                }
                ChatObject chatObject = getChatObject(context, dialogRecord2);
                SyncGroupMessage syncGroupMessage = this.mGroupSyncMap.size() < 1 ? new SyncGroupMessage(context) : null;
                if (syncGroupMessage != null) {
                    LogUtils.d(TAG, "find sync group message worker!");
                    remove(dialogRecord2, i3);
                    syncGroupMessage.setDialogRecord(dialogRecord2);
                    syncGroupMessage.setCompleteListener(new SyncStrategy.CompleteListener(this, chatObject, i2, context) { // from class: com.baidu.android.imsdk.chatmessage.sync.SyncGroupMessageService.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SyncGroupMessageService this$0;
                        public final /* synthetic */ Context val$context;
                        public final /* synthetic */ ChatObject val$key;
                        public final /* synthetic */ int val$triggerReason;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, chatObject, Integer.valueOf(i2), context};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$key = chatObject;
                            this.val$triggerReason = i2;
                            this.val$context = context;
                        }

                        @Override // com.baidu.android.imsdk.chatmessage.sync.SyncStrategy.CompleteListener
                        public void onComplete(DialogRecord dialogRecord3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogRecord3) == null) {
                                String str = SyncGroupMessageService.TAG;
                                LogUtils.d(str, "SYNCGROUP  complete " + this.val$key.getContacter() + " trigger " + this.val$triggerReason);
                                this.this$0.mGroupSyncMap.remove(this.this$0.getChatObject(this.val$context, dialogRecord3));
                                if (this.this$0.mDialogRecords.isEmpty() && this.val$triggerReason == 0) {
                                    LogUtils.d(SyncGroupMessageService.TAG, "all SYNCGROUP complete ");
                                    ChatUserManagerImpl.getInstance(this.val$context).syncUsersAttr();
                                    this.this$0.mComplete = true;
                                }
                                this.this$0.execute(this.val$context, null, -1);
                            }
                        }
                    });
                    syncGroupMessage.start(i2);
                    this.mGroupSyncMap.put(chatObject, syncGroupMessage);
                }
            }
        }
    }
}
