package com.baidu.android.imsdk.shield;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatuser.IStatusListener;
import com.baidu.android.imsdk.chatuser.db.ChatUserDBManager;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.db.PaInfoDBManager;
import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.android.imsdk.shield.model.GetSubscriptionResult;
import com.baidu.android.imsdk.shield.request.IMForbidRequest;
import com.baidu.android.imsdk.shield.request.IMGetOneShieldAndTopRequest;
import com.baidu.android.imsdk.shield.request.IMGetShieldAndTopListRequest;
import com.baidu.android.imsdk.shield.request.IMGetSubscriptionRequest;
import com.baidu.android.imsdk.shield.request.IMSetShieldAndTopRequest;
import com.baidu.android.imsdk.shield.request.IMSetSubscriptionRequest;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes8.dex */
public class ShieldAndTopManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MSG_UPDATE_MAX_COUNT = 2;
    public static final String TAG = "ShieldAndTopManager";
    public static volatile ShieldAndTopManager mInstance;
    public static volatile int mMsgUpdateCount;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-113904076, "Lcom/baidu/android/imsdk/shield/ShieldAndTopManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-113904076, "Lcom/baidu/android/imsdk/shield/ShieldAndTopManager;");
        }
    }

    public ShieldAndTopManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context.getApplicationContext();
    }

    public static /* synthetic */ int access$208() {
        int i2 = mMsgUpdateCount;
        mMsgUpdateCount = i2 + 1;
        return i2;
    }

    public static ShieldAndTopManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (mInstance == null) {
                synchronized (ShieldAndTopManager.class) {
                    if (mInstance == null) {
                        mInstance = new ShieldAndTopManager(context);
                    }
                }
            }
            return mInstance;
        }
        return (ShieldAndTopManager) invokeL.objValue;
    }

    private List<ChatSession> getShieldListFromDB(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (i2 == 2) {
                arrayList2.add(1);
                arrayList2.add(5);
                arrayList2.add(17);
                arrayList2.add(19);
                arrayList2.add(29);
                arrayList2.add(26);
                for (int i3 = 32; i3 <= 56; i3++) {
                    arrayList2.add(Integer.valueOf(i3));
                }
                arrayList.addAll(PaInfoDBManager.getInstance(this.mContext).getShieldUsers(arrayList2));
            } else {
                arrayList2.add(7);
                arrayList.addAll(PaInfoDBManager.getInstance(this.mContext).getShieldUsers(arrayList2));
                arrayList.addAll(ChatUserDBManager.getInstance(this.mContext).getShieldUsers());
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCallBack(int i2, String str, @NonNull List<ChatSession> list, String str2) {
        IGetUserShieldListener iGetUserShieldListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65545, this, new Object[]{Integer.valueOf(i2), str, list, str2}) == null) || TextUtils.isEmpty(str2) || (iGetUserShieldListener = (IGetUserShieldListener) ListenerManager.getInstance().removeListener(str2)) == null) {
            return;
        }
        LogUtils.d(TAG, "onMsgShieldListResult size :" + list.size() + ", errCode :" + i2 + ", errMsg :" + str);
        Collections.sort(list, new Comparator<ChatSession>(this) { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ShieldAndTopManager this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(ChatSession chatSession, ChatSession chatSession2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, chatSession, chatSession2)) == null) ? Long.valueOf(chatSession.getShieldTime()).compareTo(Long.valueOf(chatSession2.getShieldTime())) : invokeLL.intValue;
            }
        });
        iGetUserShieldListener.onResult(i2, str, list);
    }

    public void getGroupAndStrangerDisturbList(IGetDisturbListListener iGetDisturbListListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iGetDisturbListListener) == null) {
            requestSubbusinessContacterList(1, 3, iGetDisturbListListener != null ? ListenerManager.getInstance().addListener(iGetDisturbListListener) : "");
        }
    }

    public void getOneShieldAndTopRequest(long j2, IGetShieldAndTopListener iGetShieldAndTopListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, iGetShieldAndTopListener) == null) {
            IMGetOneShieldAndTopRequest iMGetOneShieldAndTopRequest = new IMGetOneShieldAndTopRequest(this.mContext, j2, iGetShieldAndTopListener != null ? ListenerManager.getInstance().addListener(iGetShieldAndTopListener) : "");
            HttpHelper.executor(this.mContext, iMGetOneShieldAndTopRequest, iMGetOneShieldAndTopRequest);
        }
    }

    public void getServiceNotifyMenuStatus(long j2, List<Long> list, List<String> list2, String str, int i2, IGetServiceNotifyMenuListener iGetServiceNotifyMenuListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), list, list2, str, Integer.valueOf(i2), iGetServiceNotifyMenuListener}) == null) {
            IMServiceNotifyMenuMergeListener iMServiceNotifyMenuMergeListener = new IMServiceNotifyMenuMergeListener(i2, iGetServiceNotifyMenuListener);
            if (i2 == 0) {
                getOneShieldAndTopRequest(j2, iMServiceNotifyMenuMergeListener);
            } else if (i2 != 1) {
                getOneShieldAndTopRequest(j2, iMServiceNotifyMenuMergeListener);
                getSubscription(j2, list, list2, str, iMServiceNotifyMenuMergeListener);
            } else {
                getSubscription(j2, list, list2, str, iMServiceNotifyMenuMergeListener);
            }
        }
    }

    public void getSingleContacterSetting(long j2, int i2, IGetShieldAndTopListener iGetShieldAndTopListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), iGetShieldAndTopListener}) == null) {
            IMGetOneShieldAndTopRequest iMGetOneShieldAndTopRequest = new IMGetOneShieldAndTopRequest(this.mContext, j2, i2, iGetShieldAndTopListener != null ? ListenerManager.getInstance().addListener(iGetShieldAndTopListener) : "");
            HttpHelper.executor(this.mContext, iMGetOneShieldAndTopRequest, iMGetOneShieldAndTopRequest);
        }
    }

    public void getSubscription(long j2, List<Long> list, List<String> list2, String str, IGetSubscriptionListener iGetSubscriptionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), list, list2, str, iGetSubscriptionListener}) == null) {
            if ((list != null && list.size() > 0) || (list2 != null && list2.size() > 0)) {
                IMGetSubscriptionRequest iMGetSubscriptionRequest = new IMGetSubscriptionRequest(this.mContext, j2, list, list2, str, iGetSubscriptionListener != null ? ListenerManager.getInstance().addListener(iGetSubscriptionListener) : "");
                HttpHelper.executor(this.mContext, iMGetSubscriptionRequest, iMGetSubscriptionRequest);
                return;
            }
            GetSubscriptionResult getSubscriptionResult = new GetSubscriptionResult();
            getSubscriptionResult.setErrorCode(1005);
            getSubscriptionResult.setErrorMsg(Constants.ERROR_MSG_PARAMETER_ERROR);
            iGetSubscriptionListener.onResult(getSubscriptionResult);
        }
    }

    public void getUserShieldListToShow(int i2, IGetUserShieldListener iGetUserShieldListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, iGetUserShieldListener) == null) {
            String addListener = iGetUserShieldListener != null ? ListenerManager.getInstance().addListener(iGetUserShieldListener) : "";
            if (!Utility.isNeedSync(this.mContext, Constants.KEY_SYNC_MSG_TAB_TIME)) {
                onCallBack(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, getShieldListFromDB(i2), addListener);
            } else {
                requestSubbusinessContacterList(i2, 1, addListener);
            }
        }
    }

    public void onForbidResult(int i2, String str, boolean z, String str2, String str3) {
        ISetForbidListener iSetForbidListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z), str2, str3}) == null) || TextUtils.isEmpty(str3) || (iSetForbidListener = (ISetForbidListener) ListenerManager.getInstance().removeListener(str3)) == null) {
            return;
        }
        iSetForbidListener.onResult(i2, str, z, str2);
    }

    public void onGroupMarkTopResult(int i2, String str, @NonNull ChatSession chatSession, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), str, chatSession, str2}) == null) {
            if (i2 == 0) {
                GroupInfoDAOImpl.updateGroupMarkTop(this.mContext, chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
            }
            IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
            if (iStatusListener != null) {
                iStatusListener.onResult(i2, str, chatSession.getMarkTop(), chatSession.getContacter());
            }
        }
    }

    public void onMsgMarkTopListResult(int i2, String str, List<ChatSession> list, List<ChatSession> list2, List<ChatSession> list3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), str, list, list2, list3}) == null) || list == null) {
            return;
        }
        if (!(list.size() == 0 && ((list2 == null || list2.size() == 0) && (list3 == null || list3.size() == 0))) && i2 == 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("marktop", (Integer) 0);
            ChatMessageDBManager.getInstance(this.mContext).updateChatSession("marktop=?", new String[]{String.valueOf(1)}, contentValues);
            ChatUserDBManager.getInstance(this.mContext).updateMarkTopList(list);
            PaInfoDBManager.getInstance(this.mContext).updateMarkTopList(list2);
            GroupInfoDAOImpl.updateGroupListMarkTop(this.mContext, list3);
        }
    }

    public void onMsgShieldListResult(int i2, String str, @NonNull List<ChatSession> list, @NonNull List<ChatSession> list2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, list, list2, str2}) == null) {
            ArrayList arrayList = new ArrayList();
            LogUtils.d(TAG, "onMsgShieldListResult errorCode :" + i2 + ", cUsers: " + list.size() + ", pa :" + list2.size());
            if (i2 != 0) {
                onCallBack(i2, str, getShieldListFromDB(1), str2);
            } else if (list.size() == 0 && list2.size() == 0) {
                onCallBack(i2, str, arrayList, str2);
            } else {
                if (list.size() > 0 && list2.size() > 0) {
                    MSG_UPDATE_MAX_COUNT = 2;
                } else {
                    MSG_UPDATE_MAX_COUNT = 1;
                }
                if (list.size() > 0) {
                    ChatUserDBManager.getInstance(this.mContext).getShieldUserByUids(list, !TextUtils.isEmpty(str2), new IGetUserShieldListener(this, arrayList, i2, str, str2) { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ShieldAndTopManager this$0;
                        public final /* synthetic */ int val$errorCode;
                        public final /* synthetic */ String val$errorMsg;
                        public final /* synthetic */ String val$key;
                        public final /* synthetic */ List val$shieldUsers;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList, Integer.valueOf(i2), str, str2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$shieldUsers = arrayList;
                            this.val$errorCode = i2;
                            this.val$errorMsg = str;
                            this.val$key = str2;
                        }

                        @Override // com.baidu.android.imsdk.shield.IGetUserShieldListener
                        public void onResult(int i3, String str3, List<ChatSession> list3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str3, list3) == null) {
                                ShieldAndTopManager.access$208();
                                if (list3 != null && list3.size() > 0) {
                                    List list4 = this.val$shieldUsers;
                                    list4.addAll(list4.size(), list3);
                                }
                                if (ShieldAndTopManager.mMsgUpdateCount >= ShieldAndTopManager.MSG_UPDATE_MAX_COUNT) {
                                    this.this$0.onCallBack(this.val$errorCode, this.val$errorMsg, this.val$shieldUsers, this.val$key);
                                }
                            }
                        }
                    });
                }
                if (list2.size() > 0) {
                    PaInfoDBManager.getInstance(this.mContext).getShieldUserByPaId(list2, true ^ TextUtils.isEmpty(str2), new IGetUserShieldListener(this, arrayList, i2, str, str2) { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.5
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ShieldAndTopManager this$0;
                        public final /* synthetic */ int val$errorCode;
                        public final /* synthetic */ String val$errorMsg;
                        public final /* synthetic */ String val$key;
                        public final /* synthetic */ List val$shieldUsers;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList, Integer.valueOf(i2), str, str2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$shieldUsers = arrayList;
                            this.val$errorCode = i2;
                            this.val$errorMsg = str;
                            this.val$key = str2;
                        }

                        @Override // com.baidu.android.imsdk.shield.IGetUserShieldListener
                        public void onResult(int i3, String str3, List<ChatSession> list3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str3, list3) == null) {
                                ShieldAndTopManager.access$208();
                                if (list3 != null && list3.size() > 0) {
                                    List list4 = this.val$shieldUsers;
                                    list4.addAll(list4.size(), list3);
                                }
                                if (ShieldAndTopManager.mMsgUpdateCount >= ShieldAndTopManager.MSG_UPDATE_MAX_COUNT) {
                                    this.this$0.onCallBack(this.val$errorCode, this.val$errorMsg, this.val$shieldUsers, this.val$key);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public void onNotifyShieldListResult(int i2, String str, List<ChatSession> list, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), str, list, str2}) == null) {
            if (i2 != 0) {
                onCallBack(i2, str, getShieldListFromDB(2), str2);
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (list == null || list.size() == 0) {
                onCallBack(i2, str, arrayList, str2);
            } else if (i2 == 0) {
                PaInfoDBManager.getInstance(this.mContext).getShieldUserByPaId(list, !TextUtils.isEmpty(str2), new IGetUserShieldListener(this, arrayList, str2) { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ShieldAndTopManager this$0;
                    public final /* synthetic */ String val$key;
                    public final /* synthetic */ List val$shieldUsers;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, arrayList, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$shieldUsers = arrayList;
                        this.val$key = str2;
                    }

                    @Override // com.baidu.android.imsdk.shield.IGetUserShieldListener
                    public void onResult(int i3, String str3, List<ChatSession> list2) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str3, list2) == null) && i3 == 0) {
                            if (list2 != null) {
                                this.val$shieldUsers.addAll(list2);
                            }
                            this.this$0.onCallBack(i3, str3, this.val$shieldUsers, this.val$key);
                        }
                    }
                });
            }
        }
    }

    public void onPaMarkTopResult(int i2, String str, @NonNull ChatSession chatSession, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), str, chatSession, str2}) == null) {
            IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
            if (iStatusListener != null) {
                iStatusListener.onResult(i2, str, chatSession.getMarkTop(), chatSession.getContacter());
            }
            if (i2 == 0) {
                TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable(this, chatSession) { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ShieldAndTopManager this$0;
                    public final /* synthetic */ ChatSession val$user;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, chatSession};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$user = chatSession;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            PaInfoDBManager.getInstance(this.this$0.mContext).updateMarkTop(this.val$user.getContacter(), this.val$user.getMarkTop(), this.val$user.getMarkTopTime());
                        }
                    }
                });
            }
        }
    }

    public void onPaShieldResult(int i2, String str, @NonNull ChatSession chatSession, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), str, chatSession, str2}) == null) {
            if (i2 == 0) {
                TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable(this, chatSession) { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ShieldAndTopManager this$0;
                    public final /* synthetic */ ChatSession val$user;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, chatSession};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$user = chatSession;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            PaInfoDBManager.getInstance(this.this$0.mContext).updateShield(this.val$user, false);
                        }
                    }
                });
            }
            IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
            if (iStatusListener != null) {
                iStatusListener.onResult(i2, str, chatSession.getShield(), chatSession.getContacter());
            }
        }
    }

    public void onUserMarkTopResult(int i2, String str, @NonNull ChatSession chatSession, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), str, chatSession, str2}) == null) {
            IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
            if (iStatusListener != null) {
                iStatusListener.onResult(i2, str, chatSession.getMarkTop(), chatSession.getContacter());
            }
            if (i2 == 0) {
                TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable(this, chatSession) { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ShieldAndTopManager this$0;
                    public final /* synthetic */ ChatSession val$user;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, chatSession};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$user = chatSession;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ChatUserDBManager.getInstance(this.this$0.mContext).updateMarkTop(this.val$user.getContacter(), this.val$user.getMarkTop(), this.val$user.getMarkTopTime());
                        }
                    }
                });
            }
        }
    }

    public void onUserShieldAndTopResult(GetShieldAndTopResult getShieldAndTopResult, String str) {
        IGetShieldAndTopListener iGetShieldAndTopListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, getShieldAndTopResult, str) == null) {
            if (getShieldAndTopResult != null && getShieldAndTopResult.getChatType() != 3 && getShieldAndTopResult.getErrorCode() == 0) {
                ChatSession chatSession = new ChatSession();
                chatSession.setContacter(getShieldAndTopResult.getContacter());
                chatSession.setShield(getShieldAndTopResult.getShield());
                chatSession.setShieldTime(getShieldAndTopResult.getShieldTime());
                chatSession.setMarkTop(getShieldAndTopResult.getMarkTop());
                chatSession.setMarkTopTime(getShieldAndTopResult.getMarkTopTime());
                if ((chatSession.getContacter() & Constants.PAFLAG) == 0) {
                    ChatUserDBManager.getInstance(this.mContext).updateShield(chatSession, true);
                } else {
                    PaInfoDBManager.getInstance(this.mContext).updateShield(chatSession, true);
                }
            }
            if (TextUtils.isEmpty(str) || (iGetShieldAndTopListener = (IGetShieldAndTopListener) ListenerManager.getInstance().removeListener(str)) == null) {
                return;
            }
            iGetShieldAndTopListener.onResult(getShieldAndTopResult);
        }
    }

    public void onUserShieldResult(int i2, String str, @NonNull ChatSession chatSession, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), str, chatSession, str2}) == null) {
            if (i2 == 0) {
                TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable(this, chatSession) { // from class: com.baidu.android.imsdk.shield.ShieldAndTopManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ShieldAndTopManager this$0;
                    public final /* synthetic */ ChatSession val$user;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, chatSession};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$user = chatSession;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            ChatUserDBManager.getInstance(this.this$0.mContext).updateShield(this.val$user, false);
                        }
                    }
                });
            }
            IStatusListener iStatusListener = (IStatusListener) ListenerManager.getInstance().removeListener(str2);
            if (iStatusListener != null) {
                iStatusListener.onResult(i2, str, chatSession.getShield(), chatSession.getContacter());
            }
        }
    }

    public void requestDisturbAndRemind(long j2, int i2, int i3, int i4, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iStatusListener}) == null) {
            IMSetShieldAndTopRequest iMSetShieldAndTopRequest = new IMSetShieldAndTopRequest(this.mContext, ListenerManager.getInstance().addListener(iStatusListener), j2, i2, i3, i4);
            HttpHelper.executor(this.mContext, iMSetShieldAndTopRequest, iMSetShieldAndTopRequest);
        }
    }

    public void requestMsgMarkTopList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            IMGetShieldAndTopListRequest iMGetShieldAndTopListRequest = new IMGetShieldAndTopListRequest(this.mContext, null, 2, 1);
            HttpHelper.executor(this.mContext, iMGetShieldAndTopListRequest, iMGetShieldAndTopListRequest);
        }
    }

    public void requestSubbusinessContacterList(int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048594, this, i2, i3, str) == null) {
            IMGetShieldAndTopListRequest iMGetShieldAndTopListRequest = new IMGetShieldAndTopListRequest(this.mContext, str, i3, i2);
            HttpHelper.executor(this.mContext, iMGetShieldAndTopListRequest, iMGetShieldAndTopListRequest);
        }
    }

    public void setForbid(long j2, long j3, int i2, ISetForbidListener iSetForbidListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), iSetForbidListener}) == null) {
            if (this.mContext != null) {
                IMForbidRequest iMForbidRequest = new IMForbidRequest(this.mContext, j2, j3, i2, ListenerManager.getInstance().addListener(iSetForbidListener));
                HttpHelper.executor(this.mContext, iMForbidRequest, iMForbidRequest);
            } else if (iSetForbidListener != null) {
                iSetForbidListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR, true, "");
            }
        }
    }

    public void setMarkTop(long j2, int i2, int i3, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), iStatusListener}) == null) {
            IMSetShieldAndTopRequest iMSetShieldAndTopRequest = new IMSetShieldAndTopRequest(this.mContext, ListenerManager.getInstance().addListener(iStatusListener), j2, 2, i2, i3);
            HttpHelper.executor(this.mContext, iMSetShieldAndTopRequest, iMSetShieldAndTopRequest);
        }
    }

    public void setShield(long j2, int i2, int i3, IStatusListener iStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), iStatusListener}) == null) {
            IMSetShieldAndTopRequest iMSetShieldAndTopRequest = new IMSetShieldAndTopRequest(this.mContext, ListenerManager.getInstance().addListener(iStatusListener), j2, 1, i2, i3);
            HttpHelper.executor(this.mContext, iMSetShieldAndTopRequest, iMSetShieldAndTopRequest);
        }
    }

    public void setSubscription(long j2, List<Long> list, List<String> list2, int i2, String str, ISetSubscriptionListener iSetSubscriptionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Long.valueOf(j2), list, list2, Integer.valueOf(i2), str, iSetSubscriptionListener}) == null) {
            if ((list != null && list.size() > 0) || (list2 != null && list2.size() > 0)) {
                IMSetSubscriptionRequest iMSetSubscriptionRequest = new IMSetSubscriptionRequest(this.mContext, i2, j2, list, list2, str, iSetSubscriptionListener != null ? ListenerManager.getInstance().addListener(iSetSubscriptionListener) : "");
                HttpHelper.executor(this.mContext, iMSetSubscriptionRequest, iMSetSubscriptionRequest);
                return;
            }
            iSetSubscriptionListener.onResult(1005, Constants.ERROR_MSG_PARAMETER_ERROR);
        }
    }
}
