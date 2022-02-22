package c.a.t0.s.m0.c;

import c.a.d.f.p.t;
import c.a.t0.t.c.r;
import c.a.t0.t.c.s;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NetWork a;

    /* renamed from: b  reason: collision with root package name */
    public a f13691b;

    /* renamed from: c  reason: collision with root package name */
    public s f13692c;

    /* renamed from: d  reason: collision with root package name */
    public String f13693d;

    /* renamed from: e  reason: collision with root package name */
    public String f13694e;

    /* renamed from: f  reason: collision with root package name */
    public List<C0898b> f13695f;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f13696b;

        /* renamed from: c  reason: collision with root package name */
        public r f13697c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f13698d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f13699e;

        /* renamed from: f  reason: collision with root package name */
        public String f13700f;

        public a(b bVar, String str, r rVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, rVar, str2, str3};
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
            this.f13696b = null;
            this.f13697c = null;
            this.f13699e = false;
            this.f13700f = null;
            this.a = str;
            this.f13697c = rVar;
            this.f13696b = str2;
            this.f13700f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00fa A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0115 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public s a() throws IOException {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                s sVar = new s();
                long c2 = this.f13697c.c();
                long j2 = 30720;
                long j3 = c2 / 30720;
                if (c2 % 30720 != 0) {
                    j3++;
                }
                int a = this.f13697c.a();
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
                                    NetWork netWork = new NetWork(this.f13696b);
                                    this.f13698d = netWork;
                                    netWork.addPostData("voice_chunk", bArr);
                                    this.f13698d.addPostData("chunk_md5", this.f13697c.b());
                                    this.f13698d.addPostData("length", String.valueOf(read));
                                    this.f13698d.addPostData("offset", String.valueOf(a * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                    this.f13698d.addPostData("total_length", String.valueOf(c2));
                                    this.f13698d.addPostData("chunk_no", String.valueOf(a + 1));
                                    this.f13698d.addPostData("total_num", String.valueOf(j3));
                                    this.f13698d.addPostData("voice_md5", this.f13700f);
                                    if (!this.f13699e) {
                                        if (this.f13698d.postMultiNetData() == null || !this.f13698d.getNetContext().getResponse().isRequestSuccess()) {
                                            this.f13697c.d(a);
                                            ChunkUploadDatabaseService.saveChunkUploadData(this.f13697c);
                                            randomAccessFile.close();
                                        } else {
                                            z = false;
                                            if (!z) {
                                                sVar.f(this.f13698d.getServerErrorCode());
                                                sVar.g(this.f13698d.getErrorString());
                                                sVar.e(this.f13697c);
                                                sVar.h(false);
                                                return sVar;
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
                        sVar.h(false);
                        randomAccessFile.close();
                        return sVar;
                    }
                }
                sVar.h(true);
                return sVar;
            }
            return (s) invokeV.objValue;
        }
    }

    /* renamed from: c.a.t0.s.m0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0898b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f13701b;

        public C0898b(b bVar, String str, String str2) {
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
            this.f13701b = str2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13701b : (String) invokeV.objValue;
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
        this.f13695f = new ArrayList();
        this.f13693d = str;
        this.f13694e = str2;
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            this.f13695f.add(new C0898b(this, str, String.valueOf(i2)));
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

    public final String c(String str, r rVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, rVar)) == null) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f13694e);
            this.a = netWork;
            netWork.addPostData("voice_md5", rVar.b());
            if (ListUtils.getCount(this.f13695f) != 0) {
                for (C0898b c0898b : this.f13695f) {
                    if (c0898b != null) {
                        this.a.addPostData(c0898b.a(), c0898b.b());
                    }
                }
            }
            String postNetData = this.a.postNetData();
            if (postNetData != null && this.a.getNetContext().getResponse().isRequestSuccess()) {
                ChunkUploadDatabaseService.delChunkUploadData(str);
                return postNetData;
            }
            rVar.d((int) b(rVar.c()));
            ChunkUploadDatabaseService.saveChunkUploadData(rVar);
            this.f13692c.f(this.a.getServerErrorCode());
            this.f13692c.g(this.a.getErrorString());
            this.f13692c.h(false);
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public s d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + this.f13693d);
                    return e(str, file);
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (s) invokeL.objValue;
    }

    public final s e(String str, File file) throws IOException {
        InterceptResult invokeLL;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, file)) == null) {
            String b2 = t.b(FileHelper.GetStreamFromFile(file));
            if (b2 != null && b2.length() > 0) {
                b2 = b2.toLowerCase();
            }
            r chunkUploadDataByMd5 = ChunkUploadDatabaseService.getChunkUploadDataByMd5(b2);
            if (chunkUploadDataByMd5 == null) {
                chunkUploadDataByMd5 = new r();
                chunkUploadDataByMd5.e(b2);
                chunkUploadDataByMd5.d(0);
                chunkUploadDataByMd5.f(file.length());
            }
            r rVar = chunkUploadDataByMd5;
            a aVar = new a(this, str, rVar, TbConfig.SERVER_ADDRESS + this.f13693d, b2);
            this.f13691b = aVar;
            s a2 = aVar.a();
            this.f13692c = a2;
            if (a2.d() && (c2 = c(b2, rVar)) != null && !c2.equals("")) {
                AudioInfoData audioInfoData = new AudioInfoData();
                audioInfoData.parserJson(c2);
                if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                    rVar.e(audioInfoData.getVoiceId());
                    this.f13692c.e(rVar);
                } else {
                    this.f13692c.f(audioInfoData.getErrorCode());
                    this.f13692c.g(audioInfoData.getErrorUserMsg());
                    this.f13692c.h(false);
                }
            }
            return this.f13692c;
        }
        return (s) invokeLL.objValue;
    }
}
