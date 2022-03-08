package c.a.q0.r.m0.c;

import c.a.d.f.p.t;
import c.a.q0.s.c.p;
import c.a.q0.s.c.q;
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
    public a f13107b;

    /* renamed from: c  reason: collision with root package name */
    public q f13108c;

    /* renamed from: d  reason: collision with root package name */
    public String f13109d;

    /* renamed from: e  reason: collision with root package name */
    public String f13110e;

    /* renamed from: f  reason: collision with root package name */
    public List<C0870b> f13111f;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f13112b;

        /* renamed from: c  reason: collision with root package name */
        public p f13113c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f13114d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f13115e;

        /* renamed from: f  reason: collision with root package name */
        public String f13116f;

        public a(b bVar, String str, p pVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, pVar, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.f13112b = null;
            this.f13113c = null;
            this.f13115e = false;
            this.f13116f = null;
            this.a = str;
            this.f13113c = pVar;
            this.f13112b = str2;
            this.f13116f = str3;
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
                long c2 = this.f13113c.c();
                long j2 = 30720;
                long j3 = c2 / 30720;
                if (c2 % 30720 != 0) {
                    j3++;
                }
                int a = this.f13113c.a();
                if (a < j3) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.a), "r");
                    int i2 = a * TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                    if (randomAccessFile.skipBytes(i2) >= i2) {
                        while (true) {
                            long j4 = a;
                            if (j4 < j3) {
                                long j5 = j3 - 1;
                                int i3 = j4 == j5 ? (int) (c2 - (j5 * j2)) : TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                                byte[] bArr = new byte[i3];
                                int read = randomAccessFile.read(bArr, 0, i3);
                                if (read != -1) {
                                    NetWork netWork = new NetWork(this.f13112b);
                                    this.f13114d = netWork;
                                    netWork.addPostData("voice_chunk", bArr);
                                    this.f13114d.addPostData("chunk_md5", this.f13113c.b());
                                    this.f13114d.addPostData("length", String.valueOf(read));
                                    this.f13114d.addPostData("offset", String.valueOf(a * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                    this.f13114d.addPostData("total_length", String.valueOf(c2));
                                    this.f13114d.addPostData("chunk_no", String.valueOf(a + 1));
                                    this.f13114d.addPostData("total_num", String.valueOf(j3));
                                    this.f13114d.addPostData("voice_md5", this.f13116f);
                                    if (!this.f13115e) {
                                        if (this.f13114d.postMultiNetData() == null || !this.f13114d.getNetContext().getResponse().isRequestSuccess()) {
                                            this.f13113c.d(a);
                                            ChunkUploadDatabaseService.saveChunkUploadData(this.f13113c);
                                            randomAccessFile.close();
                                        } else {
                                            z = false;
                                            if (!z) {
                                                qVar.f(this.f13114d.getServerErrorCode());
                                                qVar.g(this.f13114d.getErrorString());
                                                qVar.e(this.f13113c);
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
                                j2 = 30720;
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

    /* renamed from: c.a.q0.r.m0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0870b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f13117b;

        public C0870b(b bVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f13117b = str2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13117b : (String) invokeV.objValue;
        }
    }

    public b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13111f = new ArrayList();
        this.f13109d = str;
        this.f13110e = str2;
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            this.f13111f.add(new C0870b(this, str, String.valueOf(i2)));
        }
    }

    public final long b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2)) == null) {
            int i2 = ((j2 % 30720) > 0L ? 1 : ((j2 % 30720) == 0L ? 0 : -1));
            long j3 = j2 / 30720;
            return i2 == 0 ? j3 : j3 + 1;
        }
        return invokeJ.longValue;
    }

    public final String c(String str, p pVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, pVar)) == null) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f13110e);
            this.a = netWork;
            netWork.addPostData("voice_md5", pVar.b());
            if (ListUtils.getCount(this.f13111f) != 0) {
                for (C0870b c0870b : this.f13111f) {
                    if (c0870b != null) {
                        this.a.addPostData(c0870b.a(), c0870b.b());
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
            this.f13108c.f(this.a.getServerErrorCode());
            this.f13108c.g(this.a.getErrorString());
            this.f13108c.h(false);
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
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + this.f13109d);
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
            a aVar = new a(this, str, pVar, TbConfig.SERVER_ADDRESS + this.f13109d, b2);
            this.f13107b = aVar;
            q a2 = aVar.a();
            this.f13108c = a2;
            if (a2.d() && (c2 = c(b2, pVar)) != null && !c2.equals("")) {
                AudioInfoData audioInfoData = new AudioInfoData();
                audioInfoData.parserJson(c2);
                if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                    pVar.e(audioInfoData.getVoiceId());
                    this.f13108c.e(pVar);
                } else {
                    this.f13108c.f(audioInfoData.getErrorCode());
                    this.f13108c.g(audioInfoData.getErrorUserMsg());
                    this.f13108c.h(false);
                }
            }
            return this.f13108c;
        }
        return (q) invokeLL.objValue;
    }
}
