package com.baidu.android.imsdk.chatuser.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import com.baidu.android.imsdk.media.db.MediaMessageDBManager;
import com.baidu.android.imsdk.shield.IGetUserShieldListener;
import com.baidu.android.imsdk.task.TaskManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        setContext(context);
    }

    public static ChatUserDBManager getInstance(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
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

    private void updateAllShield(@NonNull List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65554, this, list) == null) && list.size() > 0) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                                this.this$0.updateShield(chatSession, false, true);
                            }
                        }
                    }
                }
            });
        }
    }

    public int deleteChatUser(long j) {
        InterceptResult invokeJ;
        int delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            synchronized (DBBase.mSyncLock) {
                delete = delete(TableDefine.DB_TABLE_USERINFO, "uid = ?", new String[]{String.valueOf(j)});
            }
            return delete;
        }
        return invokeJ.intValue;
    }

    public ChatUser getChatUser(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return null;
                }
                try {
                    return getChatUser(openDatabase, j);
                } catch (Exception e) {
                    LogUtils.e(TAG, "getChatUser:", e);
                    return null;
                }
            }
        }
        return (ChatUser) invokeJ.objValue;
    }

    public ChatUser getChatUserByBuid(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            synchronized (DBBase.mSyncLock) {
                SQLiteDatabase openDatabase = openDatabase();
                if (openDatabase == null) {
                    return null;
                }
                try {
                    return getChatUserByBuid(openDatabase, j);
                } catch (Exception e) {
                    LogUtils.e(TAG, "getChatUser:", e);
                    return null;
                }
            }
        }
        return (ChatUser) invokeJ.objValue;
    }

    public void updateMarkTopList(@NonNull List<ChatSession> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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

    public void updateSubscribedUsers(@NonNull Map<Long, Integer> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, map) == null) && map.size() > 0) {
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
    }

    private ChatUser constructChatUser(Cursor cursor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, cursor)) == null) {
            long j = cursor.getLong(cursor.getColumnIndex("uid"));
            long j2 = cursor.getLong(cursor.getColumnIndex("buid"));
            String string = cursor.getString(cursor.getColumnIndex("username"));
            String string2 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_HEAD_URL));
            String string3 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_TINY_URL));
            String string4 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_USER_DETAIL));
            long j3 = cursor.getLong(cursor.getColumnIndex("phone"));
            int i = cursor.getInt(cursor.getColumnIndex("sex"));
            int i2 = cursor.getInt(cursor.getColumnIndex("account_type"));
            int i3 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP_EXSIT));
            int i4 = cursor.getInt(cursor.getColumnIndex("disturb"));
            int i5 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_BLACKLIST));
            String string5 = cursor.getString(cursor.getColumnIndex("v_portrait"));
            String string6 = cursor.getString(cursor.getColumnIndex("vip_id"));
            String string7 = cursor.getString(cursor.getColumnIndex("identity"));
            long j4 = cursor.getLong(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME));
            int i6 = cursor.getInt(cursor.getColumnIndex("shield"));
            long j5 = cursor.getLong(cursor.getColumnIndex("shield_time"));
            int i7 = cursor.getInt(cursor.getColumnIndex("marktop"));
            long j6 = cursor.getLong(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_MARKTOP_TIME));
            int i8 = cursor.getInt(cursor.getColumnIndex("subscribe_status"));
            int i9 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_PHONE_RELATION));
            int i10 = cursor.getInt(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_HAS_SPECIAL_IDENTITY));
            String string8 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_SPECIAL_IDENTITY));
            String string9 = cursor.getString(cursor.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_USER_EXT));
            ChatUser chatUser = new ChatUser(j, j2, string, string2);
            chatUser.setVPortrait(string5);
            chatUser.setVipId(string6);
            chatUser.setIdentity(string7);
            chatUser.setLastUpdate(j4);
            chatUser.setShield(i6);
            chatUser.setShieldTime(j5);
            chatUser.setMarkTop(i7);
            chatUser.setMarkTopTime(j6);
            chatUser.setSubscribe(i8);
            chatUser.setPhoneRelation(i9);
            chatUser.setHasSpecialIdentity(i10);
            chatUser.setSpecialIdentity(string8);
            chatUser.setUserExt(string9);
            if (i3 == 0) {
                IpInfo ipInfo = new IpInfo();
                ipInfo.setUid(j);
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
            chatUser.setIsIpLocationExist(i3);
            chatUser.setTinyUrl(string3);
            chatUser.setUserDetail(string4);
            chatUser.setSex(i);
            chatUser.setPhone(j3);
            chatUser.setAccountType(i2);
            chatUser.setDisturb(i4);
            chatUser.setBlack(i5);
            return chatUser;
        }
        return (ChatUser) invokeL.objValue;
    }

    private ContentValues constructIpInfoContentValue(IpInfo ipInfo, ContentValues contentValues) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, ipInfo, contentValues)) == null) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0037 */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r10 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
        if (r10 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ChatUser getChatUser(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65550, this, sQLiteDatabase, j)) == null) {
            ?? r0 = 0;
            try {
                if (sQLiteDatabase == null) {
                    return null;
                }
                try {
                    cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_USERINFO, null, "uid =? ", new String[]{String.valueOf(j)}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                ChatUser constructChatUser = constructChatUser(cursor);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return constructChatUser;
                            }
                        } catch (Exception e) {
                            e = e;
                            LogUtils.e(TAG, "getChatUser:", e);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
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
        } else {
            return (ChatUser) invokeLJ.objValue;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0037 */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0034, code lost:
        if (r10 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
        if (r10 == null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ChatUser getChatUserByBuid(SQLiteDatabase sQLiteDatabase, long j) {
        InterceptResult invokeLJ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65551, this, sQLiteDatabase, j)) == null) {
            ?? r0 = 0;
            try {
                if (sQLiteDatabase == null) {
                    return null;
                }
                try {
                    cursor = sQLiteDatabase.query(TableDefine.DB_TABLE_USERINFO, null, "buid =? ", new String[]{String.valueOf(j)}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                ChatUser constructChatUser = constructChatUser(cursor);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return constructChatUser;
                            }
                        } catch (Exception e) {
                            e = e;
                            LogUtils.e(TAG, "getChatUser:", e);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
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
        } else {
            return (ChatUser) invokeLJ.objValue;
        }
    }

    private ChatSession constructShieldUsers(@NonNull ChatSession chatSession, @NonNull Cursor cursor, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65548, this, chatSession, cursor, z)) == null) {
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

    private void getUserInfo(@NonNull List<ChatSession> list, @NonNull List<ChatSession> list2, @NonNull IGetUserShieldListener iGetUserShieldListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, this, list, list2, iGetUserShieldListener) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(Long.valueOf(list.get(i).getContacter()));
            }
            String str = TAG;
            LogUtils.i(str, "getUserInfo uks " + arrayList.toString() + ", hasResult :" + list2.size());
            int size = arrayList.size();
            long[] jArr = new long[size];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2) != null) {
                    jArr[i2] = ((Long) arrayList.get(i2)).longValue();
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
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
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
                    public void onGetUidByUkResult(int i3, String str2, long[] jArr2, Map<Long, Long> map) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i3), str2, jArr2, map}) == null) {
                            if (i3 != 0) {
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
                            if (arrayList2.size() <= 0) {
                                this.val$listener.onResult(-1, "getUser failed", this.val$resultUsers);
                            } else {
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
                                            int i4 = newInitContext.flag;
                                            if ((i4 & 1) != 0) {
                                                int i5 = i4 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // com.baidu.android.imsdk.chatuser.IGetUserIdentityListener
                                    public void onGetUserIdentityResult(int i4, List<ChatUser> list3) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeIL(1048576, this, i4, list3) == null) {
                                            if (i4 == 0) {
                                                if (list3 == null) {
                                                    AnonymousClass3 anonymousClass3 = this.this$1;
                                                    anonymousClass3.val$listener.onResult(-1, "getUser failed", anonymousClass3.val$resultUsers);
                                                    return;
                                                }
                                                for (ChatSession chatSession : this.this$1.val$source) {
                                                    Iterator<ChatUser> it = list3.iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            ChatUser next = it.next();
                                                            if (next.getUk() == chatSession.getContacter()) {
                                                                AnonymousClass3 anonymousClass32 = this.this$1;
                                                                anonymousClass32.val$resultUsers.add(anonymousClass32.this$0.constructShieldUsersByChatUser(chatSession, next));
                                                                this.this$1.this$0.updateUser(next);
                                                                ChatMessageDBManager.getInstance(this.this$1.this$0.mContext).updateSessionClass(next);
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                AnonymousClass3 anonymousClass33 = this.this$1;
                                                anonymousClass33.val$listener.onResult(0, DnsModel.MSG_OK, anonymousClass33.val$resultUsers);
                                                return;
                                            }
                                            AnonymousClass3 anonymousClass34 = this.this$1;
                                            anonymousClass34.val$listener.onResult(-1, "getUser failed", anonymousClass34.val$resultUsers);
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatSession constructShieldUsersByChatUser(@NonNull ChatSession chatSession, @NonNull ChatUser chatUser) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, chatSession, chatUser)) == null) {
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
            contentValues.put("subscribe_status", Integer.valueOf(chatUser.getSubscribe()));
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_PHONE_RELATION, Integer.valueOf(chatUser.getPhoneRelation()));
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_HAS_SPECIAL_IDENTITY, Integer.valueOf(chatUser.getHasSpecialIdentity()));
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_SPECIAL_IDENTITY, chatUser.getSpecialIdentity());
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_USER_EXT, chatUser.getUserExt());
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x003b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.database.Cursor] */
    public ArrayList<ChatUser> getChatUser() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
                            } catch (Exception e) {
                                e = e;
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
                    } catch (Exception e2) {
                        e = e2;
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
        } else {
            return (ArrayList) invokeV.objValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (r0 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a6, code lost:
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00aa, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LongSparseArray<ChatUser> getChatUserByBduids(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            Cursor cursor = null;
            if (list == null || list.size() <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder(list.get(0) + "");
            for (int i = 1; i < list.size(); i++) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i));
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
                } catch (Exception e) {
                    LogUtils.e(TAG, "getChatUser:", e);
                }
            }
        } else {
            return (LongSparseArray) invokeL.objValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ae, code lost:
        if (r0 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b0, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00be, code lost:
        if (r0 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c2, code lost:
        return r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<Long> getNotExpiredChatUserByBduids(List<Long> list, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048582, this, list, j)) == null) {
            Cursor cursor = null;
            if (list == null || list.size() <= 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder(list.get(0) + "");
            for (int i = 1; i < list.size(); i++) {
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i));
            }
            String str = "buid in (" + sb.toString() + ") AND " + TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME + " > " + j;
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
                } catch (Exception e) {
                    LogUtils.e(TAG, "getChatUser:", e);
                }
            }
        } else {
            return (List) invokeLJ.objValue;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0087 */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0124, code lost:
        if (r4 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0126, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x013f, code lost:
        if (r4 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0143, code lost:
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
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{list, Boolean.valueOf(z), iGetUserShieldListener}) == null) {
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
                        String str = "";
                        if (list.size() > 0) {
                            try {
                                String str2 = "" + list.get(0).getContacter();
                                for (int i = 1; i < list.size(); i++) {
                                    str2 = str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + list.get(i).getContacter();
                                }
                                str = "uid in (" + str2 + ") ";
                            } catch (Exception e) {
                                e = e;
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
                                long j = cursor.getLong(cursor.getColumnIndex("uid"));
                                ChatSession chatSession = new ChatSession();
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= list.size()) {
                                        break;
                                    } else if (list.get(i2).getContacter() == j) {
                                        chatSession = list.get(i2);
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                                list.remove(chatSession);
                                arrayList.add(constructShieldUsers(chatSession, cursor, false));
                            } catch (Exception e2) {
                                e = e2;
                                LogUtils.e(TAG, "getShieldUser:", e);
                                iGetUserShieldListener.onResult(-1, "exception", null);
                            }
                        }
                        LogUtils.d(TAG, "getShieldUserByUids whereClause :" + str3 + ", update :" + arrayList.size() + ", user :" + list.size());
                        if (list.size() <= 0) {
                            iGetUserShieldListener.onResult(0, DnsModel.MSG_OK, arrayList);
                        } else {
                            getUserInfo(list, arrayList, iGetUserShieldListener);
                        }
                    } catch (Exception e3) {
                        e = e3;
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
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x006f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [android.database.Cursor] */
    public List<ChatSession> getShieldUsers() {
        InterceptResult invokeV;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (DBBase.mSyncLock) {
                ArrayList arrayList = new ArrayList();
                SQLiteDatabase openDatabase = openDatabase();
                ?? r11 = 0;
                try {
                    if (openDatabase == null) {
                        return null;
                    }
                    try {
                        cursor = openDatabase.query(TableDefine.DB_TABLE_USERINFO, null, "shield = ?", new String[]{String.valueOf(1)}, null, null, null, null);
                        while (cursor != null) {
                            try {
                                if (!cursor.moveToNext()) {
                                    break;
                                }
                                arrayList.add(constructShieldUsers(new ChatSession(), cursor, true));
                            } catch (Exception e) {
                                e = e;
                                LogUtils.e(TAG, "getShieldUser:", e);
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return null;
                            }
                        }
                        LogUtils.d(TAG, "whereClause :shield = ?, users :" + arrayList.size());
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    } catch (Exception e2) {
                        e = e2;
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                        if (r11 != 0) {
                            r11.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r11 = openDatabase;
                }
            }
        } else {
            return (List) invokeV.objValue;
        }
    }

    public boolean updateMarkTop(long j, int i, long j2) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Long.valueOf(j), Integer.valueOf(i), Long.valueOf(j2)})) == null) {
            String str = TAG;
            LogUtils.d(str, "updateMarkTop, uk =" + j + ", markToped=" + i + ", updateTime=" + j2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("marktop", Integer.valueOf(i));
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_MARKTOP_TIME, Long.valueOf(j2));
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("marktop", Integer.valueOf(i));
            contentValues2.put("marktoptime", Long.valueOf(j2));
            synchronized (DBBase.mSyncLock) {
                z = true;
                if (update(TableDefine.DB_TABLE_USERINFO, "uid =? ", new String[]{String.valueOf(j)}, contentValues) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                int updateChatSessionMarkTop = ChatMessageDBManager.getInstance(this.mContext).updateChatSessionMarkTop(0, j, i, j2);
                if (!z2 && updateChatSessionMarkTop <= 0) {
                    z = false;
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public boolean updateShield(@NonNull ChatSession chatSession, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        boolean z3;
        boolean z4;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{chatSession, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            synchronized (DBBase.mSyncLock) {
                ContentValues contentValues = new ContentValues();
                if (z2) {
                    contentValues.put("shield", Integer.valueOf(chatSession.getShield()));
                    contentValues.put("shield_time", Long.valueOf(chatSession.getShieldTime()));
                }
                if (z) {
                    contentValues.put("marktop", Integer.valueOf(chatSession.getMarkTop()));
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_MARKTOP_TIME, Long.valueOf(chatSession.getMarkTopTime()));
                }
                long contacter = chatSession.getContacter();
                z3 = true;
                if (update(TableDefine.DB_TABLE_USERINFO, "uid=?", new String[]{String.valueOf(contacter)}, contentValues) > 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                int updateChatSessionShield = ChatMessageDBManager.getInstance(this.mContext).updateChatSessionShield(0, contacter, chatSession.getShield(), chatSession.getShieldTime());
                MediaMessageDBManager.getInstance(this.mContext).updateChatSessionShield(0, contacter, chatSession.getShield(), chatSession.getShieldTime());
                if (z) {
                    i = ChatMessageDBManager.getInstance(this.mContext).updateChatSessionMarkTop(0, contacter, chatSession.getMarkTop(), chatSession.getMarkTopTime());
                } else {
                    i = 0;
                }
                String str = TAG;
                LogUtils.d(str, "updateShield, uk =" + chatSession.getContacter() + ", shield=" + chatSession.getShield() + ", updateTime=" + chatSession.getShieldTime() + ", userUpdated :" + z4);
                if (!z4 && i <= 0 && updateChatSessionShield <= 0) {
                    z3 = false;
                }
            }
            return z3;
        }
        return invokeCommon.booleanValue;
    }

    public boolean updateSubscribedUser(long j, int i) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("subscribe_status", Integer.valueOf(i));
            synchronized (DBBase.mSyncLock) {
                int i2 = 1;
                if (update(TableDefine.DB_TABLE_USERINFO, "buid =? ", new String[]{String.valueOf(j)}, contentValues) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                ChatUser chatUserByBuid = getChatUserByBuid(j);
                if (chatUserByBuid == null) {
                    return false;
                }
                if (chatUserByBuid.getHasSpecialIdentity() == 0 && (chatUserByBuid.getSubscribe() == 0 || chatUserByBuid.getSubscribe() == 2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    i2 = 0;
                }
                ChatMessageDBManager.getInstance(this.mContext).updateSessionStranger(0, chatUserByBuid.getUk(), i2);
                MediaMessageDBManager.getInstance(this.mContext).updateSessionStranger(0, chatUserByBuid.getUk(), i2);
                return z;
            }
        }
        return invokeCommon.booleanValue;
    }

    public long updateUser(ChatUser chatUser) {
        InterceptResult invokeL;
        long add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, chatUser)) == null) {
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

    public long updateUserByBduid(ChatUser chatUser) {
        InterceptResult invokeL;
        long add;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, chatUser)) == null) {
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
        if ((interceptable == null || interceptable.invokeL(1048592, this, list) == null) && list != null && list.size() > 0) {
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
                    contentValues.put("subscribe_status", Integer.valueOf(chatUser.getSubscribe()));
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_PHONE_RELATION, Integer.valueOf(chatUser.getPhoneRelation()));
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_HAS_SPECIAL_IDENTITY, Integer.valueOf(chatUser.getHasSpecialIdentity()));
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_SPECIAL_IDENTITY, chatUser.getSpecialIdentity());
                    contentValues.put(TableDefine.UserInfoColumns.COLUMN_USER_EXT, chatUser.getUserExt());
                    add(TableDefine.DB_TABLE_USERINFO, new String[]{"buid"}, "buid = ? ", new String[]{String.valueOf(chatUser.getBuid())}, contentValues);
                }
            }
        }
    }

    public int updateUserIpInfo(ArrayList<IpInfo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, arrayList)) == null) {
            synchronized (DBBase.mSyncLock) {
                if (arrayList == null) {
                    return -1;
                }
                if (arrayList.size() == 0) {
                    return 0;
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList2.add(i, new DBBase.UpdateArgs(this, "uid= ?", new String[]{String.valueOf(arrayList.get(i).getUid())}, constructIpInfoContentValue(arrayList.get(i), new ContentValues())));
                }
                return updateBatch(TableDefine.DB_TABLE_USERINFO, arrayList2);
            }
        }
        return invokeL.intValue;
    }
}
