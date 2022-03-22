package c.a.o0.r.m0.c;

import c.a.d.f.p.t;
import c.a.o0.s.c.p;
import c.a.o0.s.c.q;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ChunkUploadDatabaseService;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.data.AudioInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetWork a;

    /* renamed from: b  reason: collision with root package name */
    public a f10741b;

    /* renamed from: c  reason: collision with root package name */
    public q f10742c;

    /* renamed from: d  reason: collision with root package name */
    public String f10743d;

    /* renamed from: e  reason: collision with root package name */
    public String f10744e;

    /* renamed from: f  reason: collision with root package name */
    public List<C0837b> f10745f;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f10746b;

        /* renamed from: c  reason: collision with root package name */
        public p f10747c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f10748d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10749e;

        /* renamed from: f  reason: collision with root package name */
        public String f10750f;

        public a(b bVar, String str, p pVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, pVar, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f10746b = null;
            this.f10747c = null;
            this.f10749e = false;
            this.f10750f = null;
            this.a = str;
            this.f10747c = pVar;
            this.f10746b = str2;
            this.f10750f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00f6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0111 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public q a() throws IOException {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                q qVar = new q();
                long c2 = this.f10747c.c();
                long j = 30720;
                long j2 = c2 / 30720;
                if (c2 % 30720 != 0) {
                    j2++;
                }
                int a = this.f10747c.a();
                if (a < j2) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.a), "r");
                    int i = a * TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                    if (randomAccessFile.skipBytes(i) >= i) {
                        while (true) {
                            long j3 = a;
                            if (j3 < j2) {
                                long j4 = j2 - 1;
                                int i2 = j3 == j4 ? (int) (c2 - (j4 * j)) : TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                                byte[] bArr = new byte[i2];
                                int read = randomAccessFile.read(bArr, 0, i2);
                                if (read != -1) {
                                    NetWork netWork = new NetWork(this.f10746b);
                                    this.f10748d = netWork;
                                    netWork.addPostData("voice_chunk", bArr);
                                    this.f10748d.addPostData("chunk_md5", this.f10747c.b());
                                    this.f10748d.addPostData("length", String.valueOf(read));
                                    this.f10748d.addPostData("offset", String.valueOf(a * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                    this.f10748d.addPostData("total_length", String.valueOf(c2));
                                    this.f10748d.addPostData("chunk_no", String.valueOf(a + 1));
                                    this.f10748d.addPostData("total_num", String.valueOf(j2));
                                    this.f10748d.addPostData("voice_md5", this.f10750f);
                                    if (!this.f10749e) {
                                        if (this.f10748d.postMultiNetData() == null || !this.f10748d.getNetContext().getResponse().isRequestSuccess()) {
                                            this.f10747c.d(a);
                                            ChunkUploadDatabaseService.saveChunkUploadData(this.f10747c);
                                            randomAccessFile.close();
                                        } else {
                                            z = false;
                                            if (!z) {
                                                qVar.f(this.f10748d.getServerErrorCode());
                                                qVar.g(this.f10748d.getErrorString());
                                                qVar.e(this.f10747c);
                                                qVar.h(false);
                                                return qVar;
                                            }
                                        }
                                    }
                                    z = true;
                                    if (!z) {
                                    }
                                }
                                a++;
                                j = 30720;
                            } else {
                                randomAccessFile.close();
                                break;
                            }
                        }
                    } else {
                        qVar.h(false);
                        randomAccessFile.close();
                        return qVar;
                    }
                }
                qVar.h(true);
                return qVar;
            }
            return (q) invokeV.objValue;
        }
    }

    /* renamed from: c.a.o0.r.m0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0837b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f10751b;

        public C0837b(b bVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f10751b = str2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f10751b : (String) invokeV.objValue;
        }
    }

    public b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10745f = new ArrayList();
        this.f10743d = str;
        this.f10744e = str2;
    }

    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            this.f10745f.add(new C0837b(this, str, String.valueOf(i)));
        }
    }

    public final long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            int i = ((j % 30720) > 0L ? 1 : ((j % 30720) == 0L ? 0 : -1));
            long j2 = j / 30720;
            return i == 0 ? j2 : j2 + 1;
        }
        return invokeJ.longValue;
    }

    public final String c(String str, p pVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, pVar)) == null) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f10744e);
            this.a = netWork;
            netWork.addPostData("voice_md5", pVar.b());
            if (ListUtils.getCount(this.f10745f) != 0) {
                for (C0837b c0837b : this.f10745f) {
                    if (c0837b != null) {
                        this.a.addPostData(c0837b.a(), c0837b.b());
                    }
                }
            }
            String postNetData = this.a.postNetData();
            if (postNetData != null && this.a.getNetContext().getResponse().isRequestSuccess()) {
                ChunkUploadDatabaseService.delChunkUploadData(str);
                return postNetData;
            }
            pVar.d((int) b(pVar.c()));
            ChunkUploadDatabaseService.saveChunkUploadData(pVar);
            this.f10742c.f(this.a.getServerErrorCode());
            this.f10742c.g(this.a.getErrorString());
            this.f10742c.h(false);
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public q d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + this.f10743d);
                    return e(str, file);
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (q) invokeL.objValue;
    }

    public final q e(String str, File file) throws IOException {
        InterceptResult invokeLL;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, file)) == null) {
            String b2 = t.b(FileHelper.GetStreamFromFile(file));
            if (b2 != null && b2.length() > 0) {
                b2 = b2.toLowerCase();
            }
            p chunkUploadDataByMd5 = ChunkUploadDatabaseService.getChunkUploadDataByMd5(b2);
            if (chunkUploadDataByMd5 == null) {
                chunkUploadDataByMd5 = new p();
                chunkUploadDataByMd5.e(b2);
                chunkUploadDataByMd5.d(0);
                chunkUploadDataByMd5.f(file.length());
            }
            p pVar = chunkUploadDataByMd5;
            a aVar = new a(this, str, pVar, TbConfig.SERVER_ADDRESS + this.f10743d, b2);
            this.f10741b = aVar;
            q a2 = aVar.a();
            this.f10742c = a2;
            if (a2.d() && (c2 = c(b2, pVar)) != null && !c2.equals("")) {
                AudioInfoData audioInfoData = new AudioInfoData();
                audioInfoData.parserJson(c2);
                if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                    pVar.e(audioInfoData.getVoiceId());
                    this.f10742c.e(pVar);
                } else {
                    this.f10742c.f(audioInfoData.getErrorCode());
                    this.f10742c.g(audioInfoData.getErrorUserMsg());
                    this.f10742c.h(false);
                }
            }
            return this.f10742c;
        }
        return (q) invokeLL.objValue;
    }
}
