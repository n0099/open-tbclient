package c.a.p0.s.g0.c;

import c.a.p0.t.c.q;
import c.a.p0.t.c.r;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
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
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetWork f14016a;

    /* renamed from: b  reason: collision with root package name */
    public a f14017b;

    /* renamed from: c  reason: collision with root package name */
    public r f14018c;

    /* renamed from: d  reason: collision with root package name */
    public String f14019d;

    /* renamed from: e  reason: collision with root package name */
    public String f14020e;

    /* renamed from: f  reason: collision with root package name */
    public List<C0688b> f14021f;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f14022a;

        /* renamed from: b  reason: collision with root package name */
        public String f14023b;

        /* renamed from: c  reason: collision with root package name */
        public q f14024c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f14025d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f14026e;

        /* renamed from: f  reason: collision with root package name */
        public String f14027f;

        public a(b bVar, String str, q qVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, qVar, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14022a = null;
            this.f14023b = null;
            this.f14024c = null;
            this.f14026e = false;
            this.f14027f = null;
            this.f14022a = str;
            this.f14024c = qVar;
            this.f14023b = str2;
            this.f14027f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00f6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0111 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public r a() throws IOException {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                r rVar = new r();
                long c2 = this.f14024c.c();
                long j2 = 30720;
                long j3 = c2 / 30720;
                if (c2 % 30720 != 0) {
                    j3++;
                }
                int a2 = this.f14024c.a();
                if (a2 < j3) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f14022a), com.baidu.mapsdkplatform.comapi.map.r.f42169a);
                    int i2 = a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                    if (randomAccessFile.skipBytes(i2) >= i2) {
                        while (true) {
                            long j4 = a2;
                            if (j4 < j3) {
                                long j5 = j3 - 1;
                                int i3 = j4 == j5 ? (int) (c2 - (j5 * j2)) : TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                                byte[] bArr = new byte[i3];
                                int read = randomAccessFile.read(bArr, 0, i3);
                                if (read != -1) {
                                    NetWork netWork = new NetWork(this.f14023b);
                                    this.f14025d = netWork;
                                    netWork.addPostData("voice_chunk", bArr);
                                    this.f14025d.addPostData("chunk_md5", this.f14024c.b());
                                    this.f14025d.addPostData(CloudStabilityUBCUtils.KEY_LENGTH, String.valueOf(read));
                                    this.f14025d.addPostData("offset", String.valueOf(a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                    this.f14025d.addPostData("total_length", String.valueOf(c2));
                                    this.f14025d.addPostData("chunk_no", String.valueOf(a2 + 1));
                                    this.f14025d.addPostData("total_num", String.valueOf(j3));
                                    this.f14025d.addPostData("voice_md5", this.f14027f);
                                    if (!this.f14026e) {
                                        if (this.f14025d.postMultiNetData() == null || !this.f14025d.getNetContext().getResponse().isRequestSuccess()) {
                                            this.f14024c.d(a2);
                                            ChunkUploadDatabaseService.saveChunkUploadData(this.f14024c);
                                            randomAccessFile.close();
                                        } else {
                                            z = false;
                                            if (!z) {
                                                rVar.f(this.f14025d.getServerErrorCode());
                                                rVar.g(this.f14025d.getErrorString());
                                                rVar.e(this.f14024c);
                                                rVar.h(false);
                                                return rVar;
                                            }
                                        }
                                    }
                                    z = true;
                                    if (!z) {
                                    }
                                }
                                a2++;
                                j2 = 30720;
                            } else {
                                randomAccessFile.close();
                                break;
                            }
                        }
                    } else {
                        rVar.h(false);
                        randomAccessFile.close();
                        return rVar;
                    }
                }
                rVar.h(true);
                return rVar;
            }
            return (r) invokeV.objValue;
        }
    }

    /* renamed from: c.a.p0.s.g0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0688b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f14028a;

        /* renamed from: b  reason: collision with root package name */
        public String f14029b;

        public C0688b(b bVar, String str, String str2) {
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
            this.f14028a = str;
            this.f14029b = str2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14028a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14029b : (String) invokeV.objValue;
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
        this.f14021f = new ArrayList();
        this.f14019d = str;
        this.f14020e = str2;
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            this.f14021f.add(new C0688b(this, str, String.valueOf(i2)));
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

    public final String c(String str, q qVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, qVar)) == null) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f14020e);
            this.f14016a = netWork;
            netWork.addPostData("voice_md5", qVar.b());
            if (ListUtils.getCount(this.f14021f) != 0) {
                for (C0688b c0688b : this.f14021f) {
                    if (c0688b != null) {
                        this.f14016a.addPostData(c0688b.a(), c0688b.b());
                    }
                }
            }
            String postNetData = this.f14016a.postNetData();
            if (postNetData != null && this.f14016a.getNetContext().getResponse().isRequestSuccess()) {
                ChunkUploadDatabaseService.delChunkUploadData(str);
                return postNetData;
            }
            qVar.d((int) b(qVar.c()));
            ChunkUploadDatabaseService.saveChunkUploadData(qVar);
            this.f14018c.f(this.f14016a.getServerErrorCode());
            this.f14018c.g(this.f14016a.getErrorString());
            this.f14018c.h(false);
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public r d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    this.f14016a = new NetWork(TbConfig.SERVER_ADDRESS + this.f14019d);
                    return e(str, file);
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return (r) invokeL.objValue;
    }

    public final r e(String str, File file) throws IOException {
        InterceptResult invokeLL;
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, file)) == null) {
            String b2 = c.a.e.e.p.q.b(FileHelper.GetStreamFromFile(file));
            if (b2 != null && b2.length() > 0) {
                b2 = b2.toLowerCase();
            }
            q chunkUploadDataByMd5 = ChunkUploadDatabaseService.getChunkUploadDataByMd5(b2);
            if (chunkUploadDataByMd5 == null) {
                chunkUploadDataByMd5 = new q();
                chunkUploadDataByMd5.e(b2);
                chunkUploadDataByMd5.d(0);
                chunkUploadDataByMd5.f(file.length());
            }
            q qVar = chunkUploadDataByMd5;
            a aVar = new a(this, str, qVar, TbConfig.SERVER_ADDRESS + this.f14019d, b2);
            this.f14017b = aVar;
            r a2 = aVar.a();
            this.f14018c = a2;
            if (a2.d() && (c2 = c(b2, qVar)) != null && !c2.equals("")) {
                AudioInfoData audioInfoData = new AudioInfoData();
                audioInfoData.parserJson(c2);
                if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                    qVar.e(audioInfoData.getVoiceId());
                    this.f14018c.e(qVar);
                } else {
                    this.f14018c.f(audioInfoData.getErrorCode());
                    this.f14018c.g(audioInfoData.getErrorUserMsg());
                    this.f14018c.h(false);
                }
            }
            return this.f14018c;
        }
        return (r) invokeLL.objValue;
    }
}
