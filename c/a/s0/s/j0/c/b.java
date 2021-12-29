package c.a.s0.s.j0.c;

import c.a.d.f.p.t;
import c.a.s0.t.c.r;
import c.a.s0.t.c.s;
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
    public a f13517b;

    /* renamed from: c  reason: collision with root package name */
    public s f13518c;

    /* renamed from: d  reason: collision with root package name */
    public String f13519d;

    /* renamed from: e  reason: collision with root package name */
    public String f13520e;

    /* renamed from: f  reason: collision with root package name */
    public List<C0863b> f13521f;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f13522b;

        /* renamed from: c  reason: collision with root package name */
        public r f13523c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f13524d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f13525e;

        /* renamed from: f  reason: collision with root package name */
        public String f13526f;

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
            this.f13522b = null;
            this.f13523c = null;
            this.f13525e = false;
            this.f13526f = null;
            this.a = str;
            this.f13523c = rVar;
            this.f13522b = str2;
            this.f13526f = str3;
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
                long c2 = this.f13523c.c();
                long j2 = 30720;
                long j3 = c2 / 30720;
                if (c2 % 30720 != 0) {
                    j3++;
                }
                int a = this.f13523c.a();
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
                                    NetWork netWork = new NetWork(this.f13522b);
                                    this.f13524d = netWork;
                                    netWork.addPostData("voice_chunk", bArr);
                                    this.f13524d.addPostData("chunk_md5", this.f13523c.b());
                                    this.f13524d.addPostData("length", String.valueOf(read));
                                    this.f13524d.addPostData("offset", String.valueOf(a * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                    this.f13524d.addPostData("total_length", String.valueOf(c2));
                                    this.f13524d.addPostData("chunk_no", String.valueOf(a + 1));
                                    this.f13524d.addPostData("total_num", String.valueOf(j3));
                                    this.f13524d.addPostData("voice_md5", this.f13526f);
                                    if (!this.f13525e) {
                                        if (this.f13524d.postMultiNetData() == null || !this.f13524d.getNetContext().getResponse().isRequestSuccess()) {
                                            this.f13523c.d(a);
                                            ChunkUploadDatabaseService.saveChunkUploadData(this.f13523c);
                                            randomAccessFile.close();
                                        } else {
                                            z = false;
                                            if (!z) {
                                                sVar.f(this.f13524d.getServerErrorCode());
                                                sVar.g(this.f13524d.getErrorString());
                                                sVar.e(this.f13523c);
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

    /* renamed from: c.a.s0.s.j0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0863b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f13527b;

        public C0863b(b bVar, String str, String str2) {
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
            this.f13527b = str2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13527b : (String) invokeV.objValue;
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
        this.f13521f = new ArrayList();
        this.f13519d = str;
        this.f13520e = str2;
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            this.f13521f.add(new C0863b(this, str, String.valueOf(i2)));
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
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f13520e);
            this.a = netWork;
            netWork.addPostData("voice_md5", rVar.b());
            if (ListUtils.getCount(this.f13521f) != 0) {
                for (C0863b c0863b : this.f13521f) {
                    if (c0863b != null) {
                        this.a.addPostData(c0863b.a(), c0863b.b());
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
            this.f13518c.f(this.a.getServerErrorCode());
            this.f13518c.g(this.a.getErrorString());
            this.f13518c.h(false);
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
                    this.a = new NetWork(TbConfig.SERVER_ADDRESS + this.f13519d);
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
            a aVar = new a(this, str, rVar, TbConfig.SERVER_ADDRESS + this.f13519d, b2);
            this.f13517b = aVar;
            s a2 = aVar.a();
            this.f13518c = a2;
            if (a2.d() && (c2 = c(b2, rVar)) != null && !c2.equals("")) {
                AudioInfoData audioInfoData = new AudioInfoData();
                audioInfoData.parserJson(c2);
                if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                    rVar.e(audioInfoData.getVoiceId());
                    this.f13518c.e(rVar);
                } else {
                    this.f13518c.f(audioInfoData.getErrorCode());
                    this.f13518c.g(audioInfoData.getErrorUserMsg());
                    this.f13518c.h(false);
                }
            }
            return this.f13518c;
        }
        return (s) invokeLL.objValue;
    }
}
