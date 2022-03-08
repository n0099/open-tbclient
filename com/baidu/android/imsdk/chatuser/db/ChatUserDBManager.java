package com.baidu.android.imsdk.chatuser.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.account.IGetUidByUkListener;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.android.imsdk.chatuser.ChatUser;
import com.baidu.android.imsdk.chatuser.ChatUserManagerImpl;
import com.baidu.android.imsdk.chatuser.IGetUserIdentityListener;
import com.baidu.android.imsdk.chatuser.IpInfo;
import com.baidu.android.imsdk.db.DBBase;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.shield.IGetUserShieldListener;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ChatUserDBManager extends DBBase {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "ChatUserDBManager";
    public static ChatUserDBManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(901080571, "Lcom/baidu/android/imsdk/chatuser/db/ChatUserDBManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(901080571, "Lcom/baidu/android/imsdk/chatuser/db/ChatUserDBManager;");
        }
    }

    public ChatUserDBManager(Context context) {
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
        setContext(context);
    }

    private ChatUser constructChatUser(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, cursor)) == null) {
            long j2 = cursor.getLong(cursor.getColumnIndex("uid"));
            long j3 = cursor.getLong(cursor.getColumnIndex("buid"));
            String string = cursor.getString(cursor.getColumnIndex("username"));
            String string2 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_HEAD_URL));
            String string3 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_TINY_URL));
            String string4 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_USER_DETAIL));
            long j4 = cursor.getLong(cursor.getColumnIndex("phone"));
            int i2 = cursor.getInt(cursor.getColumnIndex("sex"));
            int i3 = cursor.getInt(cursor.getColumnIndex("account_type"));
            int i4 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_EXSIT));
            int i5 = cursor.getInt(cursor.getColumnIndex("disturb"));
            int i6 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_BLACKLIST));
            String string5 = cursor.getString(cursor.getColumnIndex("v_portrait"));
            String string6 = cursor.getString(cursor.getColumnIndex("vip_id"));
            String string7 = cursor.getString(cursor.getColumnIndex("identity"));
            long j5 = cursor.getLong(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME));
            int i7 = cursor.getInt(cursor.getColumnIndex("shield"));
            long j6 = cursor.getLong(cursor.getColumnIndex("shield_time"));
            int i8 = cursor.getInt(cursor.getColumnIndex("marktop"));
            long j7 = cursor.getLong(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_MARKTOP_TIME));
            int i9 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_SUBSCRIBE_STATUS));
            int i10 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_PHONE_RELATION));
            int i11 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_HAS_SPECIAL_IDENTITY));
            String string8 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_SPECIAL_IDENTITY));
            String string9 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_USER_EXT));
            ChatUser chatUser = new ChatUser(j2, j3, string, string2);
            chatUser.setVPortrait(string5);
            chatUser.setVipId(string6);
            chatUser.setIdentity(string7);
            chatUser.setLastUpdate(j5);
            chatUser.setShield(i7);
            chatUser.setShieldTime(j6);
            chatUser.setMarkTop(i8);
            chatUser.setMarkTopTime(j7);
            chatUser.setSubscribe(i9);
            chatUser.setPhoneRelation(i10);
            chatUser.setHasSpecialIdentity(i11);
            chatUser.setSpecialIdentity(string8);
            chatUser.setUserExt(string9);
            if (i4 == 0) {
                IpInfo ipInfo = new IpInfo();
                ipInfo.setUid(j2);
                String string10 = cursor.getString(cursor.getColumnIndex("ip"));
                String string11 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_ISP));
                String string12 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_COUNTRY));
                String string13 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_PROVINCE));
                String string14 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_CITY));
                String string15 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_COUNTY));
                ipInfo.setCity(string14);
                ipInfo.setProv(string13);
                ipInfo.setIp(string10);
                ipInfo.setCountry(string12);
                ipInfo.setCounty(string15);
                ipInfo.setIsp(string11);
                chatUser.setIpInfo(ipInfo);
            }
            chatUser.setIsIpLocationExist(i4);
            chatUser.setTinyUrl(string3);
            chatUser.setUserDetail(string4);
            chatUser.setSex(i2);
            chatUser.setPhone(j4);
            chatUser.setAccountType(i3);
            chatUser.setDisturb(i5);
            chatUser.setBlack(i6);
            return chatUser;
        }
        return (ChatUser) invokeL.objValue;
    }

    private ContentValues constructIpInfoContentValue(IpInfo ipInfo, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, ipInfo, contentValues)) == null) {
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP_EXSIT, String.valueOf(0));
            if (ipInfo != null) {
                contentValues.put("ip", ipInfo.getIp());
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP_ISP, ipInfo.getIsp());
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP_COUNTRY, ipInfo.getCountry());
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP_PROVINCE, ipInfo.getProv());
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP_CITY, ipInfo.getCity());
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP_COUNTY, ipInfo.getCounty());
            }
            return contentValues;
        }
        return (ContentValues) invokeLL.objValue;
    }

    private ChatSession constructShieldUsers(@NonNull ChatSession chatSession, @NonNull Cursor cursor, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65549, this, chatSession, cursor, z)) == null) {
            chatSession.setContacter(cursor.getLong(cursor.getColumnIndex("uid")));
            chatSession.setNickName(cursor.getString(cursor.getColumnIndex("username")));
            chatSession.setIconUrl(cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_HEAD_URL)));
            chatSession.setCertification(cursor.getString(cursor.getColumnIndex("identity")));
            chatSession.setVipId(cursor.getString(cursor.getColumnIndex("vip_id")));
            chatSession.setVPortrait(cursor.getString(cursor.getColumnIndex("v_portrait")));
            chatSession.setChatType(0);
            if (z) {
                chatSession.setShield(cursor.getInt(cursor.getColumnIndex("shield")));
                chatSession.setShieldTime(cursor.getLong(cursor.getColumnIndex("shield_time")));
            }
            return chatSession;
        }
        return (ChatSession) invokeLLZ.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatSession constructShieldUsersByChatUser(@NonNull ChatSession chatSession, @NonNull ChatUser chatUser) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, this, chatSession, chatUser)) == null) {
            chatSession.setContacter(chatUser.getUk());
            chatSession.setNickName(chatUser.getUserName());
            chatSession.setIconUrl(chatUser.getIconUrl());
            chatSession.setCertification(chatUser.getIdentity());
            chatSession.setVPortrait(chatUser.getVPortrait());
            chatSession.setVipId(chatUser.getVipId());
            return chatSession;
        }
        return (ChatSession) invokeLL.objValue;
    }

    public static ChatUserDBManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (mInstance == null) {
                synchronized (ChatUserDBManager.class) {
                    if (mInstance == null) {
                        mInstance = new ChatUserDBManager(context);
                    }
                }
            }
            return mInstance;
        }
        return (ChatUserDBManager) invokeL.objValue;
    }

    private void getUserInfo(@NonNull List<ChatSession> list, @NonNull List<ChatSession> list2, @NonNull IGetUserShieldListener iGetUserShieldListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, this, list, list2, iGetUserShieldListener) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                arrayList.add(Long.valueOf(list.get(i2).getContacter()));
            }
            String str = TAG;
            LogUtils.i(str, "getUserInfo uks " + arrayList.toString() + ", hasResult :" + list2.size());
            int size = arrayList.size();
            long[] jArr = new long[size];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (arrayList.get(i3) != null) {
                    jArr[i3] = ((Long) arrayList.get(i3)).longValue();
                }
            }
            if (size <= 0) {
                iGetUserShieldListener.onResult(-1, "getUser failed", list2);
            } else {
                AccountManagerImpl.getInstance(this.mContext).getUidByUk(jArr, new IGetUidByUkListener(this, iGetUserShieldListener, list2, list) { // from class: com.baidu.android.imsdk.chatuser.db.ChatUserDBManager.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ChatUserDBManager this$0;
                    public final /* synthetic */ IGetUserShieldListener val$listener;
                    public final /* synthetic */ List val$resultUsers;
                    public final /* synthetic */ List val$source;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iGetUserShieldListener, list2, list};
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
                        this.val$listener = iGetUserShieldListener;
                        this.val$resultUsers = list2;
                        this.val$source = list;
                    }

                    @Override // com.baidu.android.imsdk.account.IGetUidByUkListener
                    public void onGetUidByUkResult(int i4, String str2, long[] jArr2, Map<Long, Long> map) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i4), str2, jArr2, map}) == null) {
                            if (i4 != 0) {
                                this.val$listener.onResult(-1, "getUser failed", this.val$resultUsers);
                                return;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            for (Map.Entry<Long, Long> entry : map.entrySet()) {
                                if (entry.getValue().longValue() > 0) {
                                    arrayList2.add(entry.getValue());
                                }
                            }
                            String str3 = ChatUserDBManager.TAG;
                            LogUtils.e(str3, "getUidByUk  result :" + this.val$resultUsers.size() + ", bduid :" + arrayList2.toString());
                            if (arrayList2.size() > 0) {
                                ChatUserManagerImpl.getInstance(this.this$0.mContext).updateUserIdentity(arrayList2, new IGetUserIdentityListener(this) { // from class: com.baidu.android.imsdk.chatuser.db.ChatUserDBManager.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass3 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i5 = newInitContext.flag;
                                            if ((i5 & 1) != 0) {
                                                int i6 = i5 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                                    public void onGetUserIdentityResult(int i5, List<ChatUser> list3) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i5, list3) == null) {
                                            if (i5 != 0) {
                                                AnonymousClass3 anonymousClass3 = this.this$1;
                                                anonymousClass3.val$listener.onResult(-1, "getUser failed", anonymousClass3.val$resultUsers);
                                            } else if (list3 == null) {
                                                AnonymousClass3 anonymousClass32 = this.this$1;
                                                anonymousClass32.val$listener.onResult(-1, "getUser failed", anonymousClass32.val$resultUsers);
                                            } else {
                                                for (ChatSession chatSession : this.this$1.val$source) {
                                                    Iterator<ChatUser> it = list3.iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            ChatUser next = it.next();
                                                            if (next.getUk() == chatSession.getContacter()) {
                                                                AnonymousClass3 anonymousClass33 = this.this$1;
                                                                anonymousClass33.val$resultUsers.add(anonymousClass33.this$0.constructShieldUsersByChatUser(chatSession, next));
                                                                this.this$1.this$0.updateUser(next);
                                                                ChatMessageDBManager.getInstance(this.this$1.this$0.mContext).updateSessionClass(next);
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                AnonymousClass3 anonymousClass34 = this.this$1;
                                                anonymousClass34.val$listener.onResult(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, anonymousClass34.val$resultUsers);
                                                AnonymousClass3 anonymousClass35 = this.this$1;
                                                anonymousClass35.this$0.updateAllShield(anonymousClass35.val$resultUsers);
                                            }
                                        }
                                    }
                                });
                            } else {
                                this.val$listener.onResult(-1, "getUser failed", this.val$resultUsers);
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAllShield(@NonNull List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, list) == null) || list.size() <= 0) {
            return;
        }
        TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable(this, list) { // from class: com.baidu.android.imsdk.chatuser.db.ChatUserDBManager.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatUserDBManager this$0;
            public final /* synthetic */ List val$users;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, list};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$users = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (DBBase.mSyncLock) {
                        for (ChatSession chatSession : this.val$users) {
                            this.this$0.updateShield(chatSession, false);
                        }
                    }
                }
            }
        });
    }

    public ContentValues constructChatUserContentValues(ChatUser chatUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chatUser)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("uid", Long.valueOf(chatUser.getUk()));
            contentValues.put("buid", Long.valueOf(chatUser.getBuid()));
            contentValues.put("username", chatUser.getUserName());
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_HEAD_URL, chatUser.getIconUrl());
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_TINY_URL, chatUser.getTinyUrl());
            contentValues.put("sex", Integer.valueOf(chatUser.getSex()));
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_USER_DETAIL, chatUser.getUserDetail());
            contentValues.put("phone", Long.valueOf(chatUser.getPhone()));
            contentValues.put("account_type", Integer.valueOf(chatUser.getAccountType()));
            contentValues.put("disturb", Integer.valueOf(chatUser.getDisturb()));
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_BLACKLIST, Integer.valueOf(chatUser.getBlack()));
            contentValues.put("v_portrait", chatUser.getVPortrait());
            contentValues.put("vip_id", chatUser.getVipId());
            contentValues.put("identity", chatUser.getIdentity());
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, Long.valueOf(chatUser.getLastUpdate()));
            contentValues.put("shield", Integer.valueOf(chatUser.getShield()));
            contentValues.put("shield_time", Long.valueOf(chatUser.getShieldTime()));
            contentValues.put("marktop", Integer.valueOf(chatUser.getMarkTop()));
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_MARKTOP_TIME, Long.valueOf(chatUser.getMarkTopTime()));
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_SUBSCRIBE_STATUS, Integer.valueOf(chatUser.getSubscribe()));
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_PHONE_RELATION, Integer.valueOf(chatUser.getPhoneRelation()));
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_HAS_SPECIAL_IDENTITY, Integer.valueOf(chatUser.getHasSpecialIdentity()));
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_SPECIAL_IDENTITY, chatUser.getSpecialIdentity());
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_USER_EXT, chatUser.getUserExt());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public int deleteChatUser(long j2) {
        InterceptResult invokeJ;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            synchronized (DBBase.mSyncLock) {
                delete = delete(TableDefine.DB_TABLE_USERINFO, "uid = ?", new String[]{String.valueOf(j2)});
            }
            return delete;
        }
        return invokeJ.intValue;
    }

    public ChatUser getChatUser(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return null;
                }
                try {
                    return getChatUser(openDatabase, j2);
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(TAG, "getChatUser:", e2);
                    return null;
                }
            }
        }
        return (ChatUser) invokeJ.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0095, code lost:
        if (r0 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0097, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b7, code lost:
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bb, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LongSparseArray<ChatUser> getChatUserByBduids(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048580, this, list)) != null) {
            return (LongSparseArray) invokeL.objValue;
        }
        Cursor cursor = null;
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(list.get(0) + "");
        for (int i2 = 1; i2 < list.size(); i2++) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i2));
        }
        String str = "buid in (" + sb.toString() + ") ";
        LongSparseArray<ChatUser> longSparseArray = new LongSparseArray<>();
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_USERINFO, null, str, null, null, null, null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    ChatUser constructChatUser = constructChatUser(cursor);
                    longSparseArray.put(constructChatUser.getBuid(), constructChatUser);
                }
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "getChatUser:", e2);
            }
        }
    }

    public ChatUser getChatUserByBuid(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return null;
                }
                try {
                    return getChatUserByBuid(openDatabase, j2);
                } catch (Exception e2) {
                    new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                    LogUtils.e(TAG, "getChatUser:", e2);
                    return null;
                }
            }
        }
        return (ChatUser) invokeJ.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ad, code lost:
        if (r0 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cf, code lost:
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d3, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Long> getNotExpiredChatUserByBduids(List<Long> list, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(1048582, this, list, j2)) != null) {
            return (List) invokeLJ.objValue;
        }
        Cursor cursor = null;
        if (list == null || list.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(list.get(0) + "");
        for (int i2 = 1; i2 < list.size(); i2++) {
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i2));
        }
        String str = "buid in (" + sb.toString() + ") AND " + TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME + " > " + j2;
        ArrayList arrayList = new ArrayList();
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            if (openDatabase == null) {
                return null;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_USERINFO, new String[]{"buid"}, str, null, null, null, null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    arrayList.add(Long.valueOf(cursor.getLong(cursor.getColumnIndex("buid"))));
                }
            } catch (Exception e2) {
                new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
                LogUtils.e(TAG, "getChatUser:", e2);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x00a4 */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0143, code lost:
        if (r4 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0145, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x015e, code lost:
        if (r4 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0162, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getShieldUserByUids(@NonNull List<ChatSession> list, boolean z, @NonNull IGetUserShieldListener iGetUserShieldListener) {
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048583, this, new Object[]{list, Boolean.valueOf(z), iGetUserShieldListener}) != null) {
            return;
        }
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            ArrayList arrayList = new ArrayList();
            ?? r15 = 0;
            try {
                if (openDatabase == null) {
                    iGetUserShieldListener.onResult(-1, "db failed", null);
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("shield", (Integer) 0);
                    openDatabase.update(TableDefine.DB_TABLE_USERINFO, contentValues, "shield=?", new String[]{String.valueOf(1)});
                    String str = "";
                    if (list.size() > 0) {
                        try {
                            String str2 = "" + list.get(0).getContacter();
                            for (int i2 = 1; i2 < list.size(); i2++) {
                                str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i2).getContacter();
                            }
                            str = "uid in (" + str2 + ") ";
                        } catch (Exception e2) {
                            e = e2;
                            cursor = null;
                            LogUtils.e(TAG, "getShieldUser:", e);
                            iGetUserShieldListener.onResult(-1, "exception", null);
                        } catch (Throwable th) {
                            th = th;
                            if (r15 != 0) {
                                r15.close();
                            }
                            throw th;
                        }
                    }
                    String str3 = str;
                    cursor = openDatabase.query(TableDefine.DB_TABLE_USERINFO, null, str3, null, null, null, null, null);
                    while (cursor != null) {
                        try {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            long j2 = cursor.getLong(cursor.getColumnIndex("uid"));
                            ChatSession chatSession = new ChatSession();
                            int i3 = 0;
                            while (true) {
                                if (i3 >= list.size()) {
                                    break;
                                } else if (list.get(i3).getContacter() == j2) {
                                    chatSession = list.get(i3);
                                    break;
                                } else {
                                    i3++;
                                }
                            }
                            list.remove(chatSession);
                            arrayList.add(constructShieldUsers(chatSession, cursor, false));
                        } catch (Exception e3) {
                            e = e3;
                            LogUtils.e(TAG, "getShieldUser:", e);
                            iGetUserShieldListener.onResult(-1, "exception", null);
                        }
                    }
                    LogUtils.d(TAG, "getShieldUserByUids whereClause :" + str3 + ", update :" + arrayList.size() + ", user :" + list.size());
                    updateAllShield(arrayList);
                    if (list.size() <= 0) {
                        iGetUserShieldListener.onResult(0, NewBindCardEntry.BING_CARD_SUCCESS_MSG, arrayList);
                    } else {
                        getUserInfo(list, arrayList, iGetUserShieldListener);
                    }
                } catch (Exception e4) {
                    e = e4;
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                    r15 = 0;
                }
            } catch (Throwable th3) {
                th = th3;
                r15 = openDatabase;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0083 A[Catch: all -> 0x0087, TryCatch #2 {, blocks: (B:6:0x0007, B:8:0x0013, B:17:0x0066, B:18:0x0069, B:28:0x007a, B:29:0x007d, B:34:0x0083, B:35:0x0086), top: B:45:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<ChatSession> getShieldUsers() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) != null) {
            return (List) invokeV.objValue;
        }
        synchronized (DBBase.mSyncLock) {
            ArrayList arrayList = new ArrayList();
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor2 = null;
            if (openDatabase == null) {
                return null;
            }
            try {
                cursor = openDatabase.query(TableDefine.DB_TABLE_USERINFO, null, "shield = ?", new String[]{String.valueOf(1)}, null, null, null, null);
                while (cursor != null) {
                    try {
                        try {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            arrayList.add(constructShieldUsers(new ChatSession(), cursor, true));
                        } catch (Exception e2) {
                            e = e2;
                            LogUtils.e(TAG, "getShieldUser:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
                LogUtils.d(TAG, "whereClause :shield = ?, users :" + arrayList.size());
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor2 != null) {
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: long */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
        if (r11 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
        if (r11 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0071, code lost:
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Long getUkByBuid(long j2) {
        InterceptResult invokeJ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeJ = interceptable.invokeJ(1048585, this, j2)) != null) {
            return (Long) invokeJ.objValue;
        }
        synchronized (DBBase.mSyncLock) {
            SQLiteDatabase openDatabase = openDatabase();
            Cursor cursor2 = null;
            try {
                if (openDatabase == null) {
                    return null;
                }
                try {
                    cursor = openDatabase.query(TableDefine.DB_TABLE_USERINFO, new String[]{"uid"}, "buid =? ", new String[]{String.valueOf(j2)}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("uid")));
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return valueOf;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getChatUser:", e);
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = j2;
            }
        }
    }

    public boolean isUserExist(SQLiteDatabase sQLiteDatabase, long j2) {
        InterceptResult invokeLJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048586, this, sQLiteDatabase, j2)) == null) {
            synchronized (DBBase.mSyncLock) {
                z = true;
                if (queryCount(TableDefine.DB_TABLE_USERINFO, new String[]{"uid"}, "uid=?", new String[]{String.valueOf(j2)}) <= 0) {
                    z = false;
                }
            }
            return z;
        }
        return invokeLJ.booleanValue;
    }

    public boolean updateMarkTop(long j2, int i2, long j3) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3)})) == null) {
            String str = TAG;
            LogUtils.d(str, "updateMarkTop, uk =" + j2 + ", markToped=" + i2 + ", updateTime=" + j3);
            ContentValues contentValues = new ContentValues();
            contentValues.put("marktop", Integer.valueOf(i2));
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_MARKTOP_TIME, Long.valueOf(j3));
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("marktop", Integer.valueOf(i2));
            contentValues2.put("marktoptime", Long.valueOf(j3));
            synchronized (DBBase.mSyncLock) {
                z = true;
                boolean z2 = update(TableDefine.DB_TABLE_USERINFO, "uid =? ", new String[]{String.valueOf(j2)}, contentValues) > 0;
                boolean z3 = update(TableDefine.DB_TABLE_CHAT_SESSION, "contacter =? ", new String[]{String.valueOf(j2)}, contentValues2) > 0;
                if (!z2 && !z3) {
                    z = false;
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public void updateMarkTopList(@NonNull List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable(this, list) { // from class: com.baidu.android.imsdk.chatuser.db.ChatUserDBManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatUserDBManager this$0;
                public final /* synthetic */ List val$users;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, list};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$users = list;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (DBBase.mSyncLock) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("marktop", (Integer) 0);
                            this.this$0.update(TableDefine.DB_TABLE_USERINFO, "marktop=?", new String[]{String.valueOf(1)}, contentValues);
                            if (this.val$users != null) {
                                for (ChatSession chatSession : this.val$users) {
                                    this.this$0.updateMarkTop(chatSession.getContacter(), chatSession.getMarkTop(), chatSession.getMarkTopTime());
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public boolean updateShield(@NonNull ChatSession chatSession, boolean z) {
        InterceptResult invokeLZ;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, chatSession, z)) == null) {
            synchronized (DBBase.mSyncLock) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("shield", Integer.valueOf(chatSession.getShield()));
                contentValues.put("shield_time", Long.valueOf(chatSession.getShieldTime()));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("shield", Integer.valueOf(chatSession.getShield()));
                contentValues2.put("shield_time", Long.valueOf(chatSession.getShieldTime()));
                if (z) {
                    contentValues.put("marktop", Integer.valueOf(chatSession.getMarkTop()));
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_MARKTOP_TIME, Long.valueOf(chatSession.getMarkTopTime()));
                    contentValues2.put("marktop", Integer.valueOf(chatSession.getMarkTop()));
                    contentValues2.put("marktoptime", Long.valueOf(chatSession.getMarkTopTime()));
                }
                long contacter = chatSession.getContacter();
                z2 = true;
                boolean z3 = update(TableDefine.DB_TABLE_USERINFO, "uid=?", new String[]{String.valueOf(contacter)}, contentValues) > 0;
                boolean z4 = update(TableDefine.DB_TABLE_CHAT_SESSION, "contacter =? ", new String[]{String.valueOf(contacter)}, contentValues2) > 0;
                String str = TAG;
                LogUtils.d(str, "updateShield, uk =" + chatSession.getContacter() + ", shield=" + chatSession.getShield() + ", updateTime=" + chatSession.getShieldTime() + ", userUpdated :" + z3);
                if (!z3 && !z4) {
                    z2 = false;
                }
            }
            return z2;
        }
        return invokeLZ.booleanValue;
    }

    public boolean updateSubscribedUser(long j2, int i2) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_SUBSCRIBE_STATUS, Integer.valueOf(i2));
            synchronized (DBBase.mSyncLock) {
                z = true;
                if (update(TableDefine.DB_TABLE_USERINFO, "uid =? ", new String[]{String.valueOf(j2)}, contentValues) <= 0) {
                    z = false;
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public void updateSubscribedUsers(@NonNull Map<Long, Integer> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, map) == null) || map.size() <= 0) {
            return;
        }
        TaskManager.getInstance(this.mContext).submitForLocalOperation(new Runnable(this, map) { // from class: com.baidu.android.imsdk.chatuser.db.ChatUserDBManager.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ChatUserDBManager this$0;
            public final /* synthetic */ Map val$uidStatusList;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, map};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$uidStatusList = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    synchronized (DBBase.mSyncLock) {
                        for (Map.Entry entry : this.val$uidStatusList.entrySet()) {
                            this.this$0.updateSubscribedUser(((Long) entry.getKey()).longValue(), ((Integer) entry.getValue()).intValue());
                        }
                    }
                }
            }
        });
    }

    public int updateUser(ArrayList<ChatUser> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, arrayList)) == null) {
            synchronized (DBBase.mSyncLock) {
                if (arrayList == null) {
                    LogUtils.i(TAG, "update users with null!");
                    return -1;
                } else if (arrayList.size() == 0) {
                    return 0;
                } else {
                    ArrayList arrayList2 = new ArrayList(arrayList.size());
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("username", arrayList.get(i2).getUserName());
                        contentValues.put(TableDefine.UserInfoColumns.COLUMN_HEAD_URL, arrayList.get(i2).getIconUrl());
                        contentValues.put(TableDefine.UserInfoColumns.COLUMN_TINY_URL, arrayList.get(i2).getTinyUrl());
                        arrayList2.add(i2, new DBBase.UpdateArgs(this, "uid = ? ", new String[]{String.valueOf(arrayList.get(i2).getUk())}, contentValues));
                    }
                    return updateBatch(TableDefine.DB_TABLE_USERINFO, arrayList2);
                }
            }
        }
        return invokeL.intValue;
    }

    public long updateUserByBduid(ChatUser chatUser) {
        InterceptResult invokeL;
        long add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, chatUser)) == null) {
            if (chatUser == null) {
                return 0L;
            }
            synchronized (DBBase.mSyncLock) {
                add = add(TableDefine.DB_TABLE_USERINFO, new String[]{"buid"}, "buid = ? ", new String[]{String.valueOf(chatUser.getBuid())}, constructChatUserContentValues(chatUser));
            }
            return add;
        }
        return invokeL.longValue;
    }

    public void updateUserIdentity(List<ChatUser> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        synchronized (DBBase.mSyncLock) {
            for (ChatUser chatUser : list) {
                ContentValues contentValues = new ContentValues();
                if (chatUser.getUk() > 0) {
                    contentValues.put("uid", Long.valueOf(chatUser.getUk()));
                }
                contentValues.put("buid", Long.valueOf(chatUser.getBuid()));
                contentValues.put("username", chatUser.getUserName());
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_HEAD_URL, chatUser.getIconUrl());
                contentValues.put("v_portrait", chatUser.getVPortrait());
                contentValues.put("vip_id", chatUser.getVipId());
                contentValues.put("identity", chatUser.getIdentity());
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, Long.valueOf(System.currentTimeMillis()));
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_SUBSCRIBE_STATUS, Integer.valueOf(chatUser.getSubscribe()));
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_PHONE_RELATION, Integer.valueOf(chatUser.getPhoneRelation()));
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_HAS_SPECIAL_IDENTITY, Integer.valueOf(chatUser.getHasSpecialIdentity()));
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_SPECIAL_IDENTITY, chatUser.getSpecialIdentity());
                contentValues.put(TableDefine.UserInfoColumns.COLUMN_USER_EXT, chatUser.getUserExt());
                add(TableDefine.DB_TABLE_USERINFO, new String[]{"buid"}, "buid = ? ", new String[]{String.valueOf(chatUser.getBuid())}, contentValues);
            }
        }
    }

    public int updateUserIp(long j2, int i2) {
        InterceptResult invokeCommon;
        int update;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            synchronized (DBBase.mSyncLock) {
                update = update(TableDefine.DB_TABLE_USERINFO, "uid= ?", new String[]{String.valueOf(j2)}, constructIpInfoContentValue(null, new ContentValues()));
            }
            return update;
        }
        return invokeCommon.intValue;
    }

    public int updateUserIpInfo(ArrayList<IpInfo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, arrayList)) == null) {
            synchronized (DBBase.mSyncLock) {
                if (arrayList == null) {
                    return -1;
                }
                if (arrayList.size() == 0) {
                    return 0;
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    arrayList2.add(i2, new DBBase.UpdateArgs(this, "uid= ?", new String[]{String.valueOf(arrayList.get(i2).getUid())}, constructIpInfoContentValue(arrayList.get(i2), new ContentValues())));
                }
                return updateBatch(TableDefine.DB_TABLE_USERINFO, arrayList2);
            }
        }
        return invokeL.intValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0039 */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r10 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
        if (r10 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ChatUser getChatUser(SQLiteDatabase sQLiteDatabase, long j2) {
        InterceptResult invokeLJ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(65551, this, sQLiteDatabase, j2)) != null) {
            return (ChatUser) invokeLJ.objValue;
        }
        ?? r0 = 0;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_USERINFO, null, "uid =? ", new String[]{String.valueOf(j2)}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            ChatUser constructChatUser = constructChatUser(cursor);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return constructChatUser;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getChatUser:", e);
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r0 = sQLiteDatabase;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0039 */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r10 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
        if (r10 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ChatUser getChatUserByBuid(SQLiteDatabase sQLiteDatabase, long j2) {
        InterceptResult invokeLJ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(65552, this, sQLiteDatabase, j2)) != null) {
            return (ChatUser) invokeLJ.objValue;
        }
        ?? r0 = 0;
        try {
            if (sQLiteDatabase == null) {
                return null;
            }
            try {
                cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_USERINFO, null, "buid =? ", new String[]{String.valueOf(j2)}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            ChatUser constructChatUser = constructChatUser(cursor);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return constructChatUser;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                        LogUtils.e(TAG, "getChatUser:", e);
                    }
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            r0 = sQLiteDatabase;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x003a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.database.Cursor] */
    public ArrayList<ChatUser> getChatUser() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return (ArrayList) invokeV.objValue;
        }
        synchronized (DBBase.mSyncLock) {
            ArrayList<ChatUser> arrayList = new ArrayList<>();
            SQLiteDatabase openDatabase = openDatabase();
            ?? r10 = 0;
            try {
                if (openDatabase == null) {
                    return null;
                }
                try {
                    cursor = openDatabase.query(TableDefine.DB_TABLE_USERINFO, null, null, null, null, null, null);
                    while (cursor != null) {
                        try {
                            if (!cursor.moveToNext()) {
                                break;
                            }
                            arrayList.add(constructChatUser(cursor));
                        } catch (Exception e2) {
                            e = e2;
                            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
                            LogUtils.e(TAG, "getChatUser:", e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (r10 != 0) {
                        r10.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                r10 = openDatabase;
            }
        }
    }

    public long updateUser(ChatUser chatUser) {
        InterceptResult invokeL;
        long add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, chatUser)) == null) {
            if (chatUser == null) {
                return 0L;
            }
            synchronized (DBBase.mSyncLock) {
                add = add(TableDefine.DB_TABLE_USERINFO, new String[]{"uid"}, "uid = ? ", new String[]{String.valueOf(chatUser.getUk())}, constructChatUserContentValues(chatUser));
            }
            return add;
        }
        return invokeL.longValue;
    }
}
