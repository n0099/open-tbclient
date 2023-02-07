package com.baidu.bdtask.service.cache.storage.storer.file;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.bdtask.service.cache.storage.storer.file.history.b;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u0010:\u0001\u0010B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/baidu/bdtask/service/cache/storage/storer/file/FileStorageStorer;", "Ljava/io/File;", "file", "", "isEmpty", "(Ljava/io/File;)Z", "", StatConstants.VALUE_FROM_RETRIEVE, "()[B", "data", "", "store", "([B)V", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "Companion", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static final C0092a b;
    public transient /* synthetic */ FieldHolder $fh;
    public final File a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1328499172, "Lcom/baidu/bdtask/service/cache/storage/storer/file/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1328499172, "Lcom/baidu/bdtask/service/cache/storage/storer/file/a;");
                return;
            }
        }
        b = new C0092a(null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/baidu/bdtask/service/cache/storage/storer/file/FileStorageStorer$Companion;", "Lcom/baidu/bdtask/service/cache/storage/storer/file/history/b;", "Lcom/baidu/bdtask/service/cache/storage/storer/file/FileStorageStorer;", "with", "()Lcom/baidu/bdtask/service/cache/storage/storer/file/FileStorageStorer;", "<init>", "()V", "lib-bdtask-business-build_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* renamed from: com.baidu.bdtask.service.cache.storage.storer.file.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0092a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0092a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C0092a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public void b(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) {
                b.a.a(this, file);
            }
        }

        public final a a() {
            InterceptResult invokeV;
            File file;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                File file2 = null;
                try {
                    String d = com.baidu.bdtask.service.cache.storage.storer.file.history.a.a.d();
                    File file3 = new File(d);
                    if (file3.isFile()) {
                        file3.delete();
                    }
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                    file = new File(d, com.baidu.bdtask.service.cache.storage.storer.file.history.a.a.b("v2"));
                    try {
                        b(file);
                    } catch (Throwable th) {
                        th = th;
                        file2 = file;
                        DebugTrace.a.c(new Function0<String>(th) { // from class: com.baidu.bdtask.service.cache.storage.storer.file.FileStorageStorer$Companion$with$1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Throwable $throwAble;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {th};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        super(((Integer) newInitContext.callArgs[0]).intValue());
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.$throwAble = th;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // kotlin.jvm.functions.Function0
                            public final String invoke() {
                                InterceptResult invokeV2;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                    return "FileStorageStorer can not create storageFile  by " + this.$throwAble.getMessage();
                                }
                                return (String) invokeV2.objValue;
                            }
                        });
                        file = file2;
                        return new a(file);
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                return new a(file);
            }
            return (a) invokeV.objValue;
        }
    }

    public a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = file;
    }

    public void a(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bArr) == null) {
            try {
                File file = this.a;
                if (file != null) {
                    FilesKt__FileReadWriteKt.writeBytes(file, bArr);
                }
            } catch (Throwable th) {
                DebugTrace.a.c(new Function0<String>(th) { // from class: com.baidu.bdtask.service.cache.storage.storer.file.FileStorageStorer$store$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Throwable $throwAble;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {th};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super(((Integer) newInitContext.callArgs[0]).intValue());
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$throwAble = th;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return "can not store by " + this.$throwAble.getMessage();
                        }
                        return (String) invokeV.objValue;
                    }
                });
            }
        }
    }

    public final boolean b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) {
            if (file.exists() && file.length() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public byte[] c() {
        InterceptResult invokeV;
        byte[] readBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            File file = this.a;
            if (file != null) {
                try {
                    if (b(file)) {
                        readBytes = new byte[0];
                    } else {
                        readBytes = FilesKt__FileReadWriteKt.readBytes(this.a);
                    }
                    return readBytes;
                } catch (Throwable th) {
                    DebugTrace.a.c(new Function0<String>(th) { // from class: com.baidu.bdtask.service.cache.storage.storer.file.FileStorageStorer$retrieve$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Throwable $throwAble;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {th};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    super(((Integer) newInitContext.callArgs[0]).intValue());
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.$throwAble = th;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            InterceptResult invokeV2;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                                return "can not retrieve by " + this.$throwAble.getMessage();
                            }
                            return (String) invokeV2.objValue;
                        }
                    });
                    return new byte[0];
                }
            }
            return new byte[0];
        }
        return (byte[]) invokeV.objValue;
    }
}
