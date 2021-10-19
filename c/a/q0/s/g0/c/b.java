package c.a.q0.s.g0.c;

import c.a.q0.t.c.q;
import c.a.q0.t.c.r;
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
    public NetWork f13989a;

    /* renamed from: b  reason: collision with root package name */
    public a f13990b;

    /* renamed from: c  reason: collision with root package name */
    public r f13991c;

    /* renamed from: d  reason: collision with root package name */
    public String f13992d;

    /* renamed from: e  reason: collision with root package name */
    public String f13993e;

    /* renamed from: f  reason: collision with root package name */
    public List<C0688b> f13994f;

    /* loaded from: classes3.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f13995a;

        /* renamed from: b  reason: collision with root package name */
        public String f13996b;

        /* renamed from: c  reason: collision with root package name */
        public q f13997c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f13998d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f13999e;

        /* renamed from: f  reason: collision with root package name */
        public String f14000f;

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
            this.f13995a = null;
            this.f13996b = null;
            this.f13997c = null;
            this.f13999e = false;
            this.f14000f = null;
            this.f13995a = str;
            this.f13997c = qVar;
            this.f13996b = str2;
            this.f14000f = str3;
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
                long c2 = this.f13997c.c();
                long j2 = 30720;
                long j3 = c2 / 30720;
                if (c2 % 30720 != 0) {
                    j3++;
                }
                int a2 = this.f13997c.a();
                if (a2 < j3) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f13995a), com.baidu.mapsdkplatform.comapi.map.r.f42346a);
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
                                    NetWork netWork = new NetWork(this.f13996b);
                                    this.f13998d = netWork;
                                    netWork.addPostData("voice_chunk", bArr);
                                    this.f13998d.addPostData("chunk_md5", this.f13997c.b());
                                    this.f13998d.addPostData(CloudStabilityUBCUtils.KEY_LENGTH, String.valueOf(read));
                                    this.f13998d.addPostData("offset", String.valueOf(a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                    this.f13998d.addPostData("total_length", String.valueOf(c2));
                                    this.f13998d.addPostData("chunk_no", String.valueOf(a2 + 1));
                                    this.f13998d.addPostData("total_num", String.valueOf(j3));
                                    this.f13998d.addPostData("voice_md5", this.f14000f);
                                    if (!this.f13999e) {
                                        if (this.f13998d.postMultiNetData() == null || !this.f13998d.getNetContext().getResponse().isRequestSuccess()) {
                                            this.f13997c.d(a2);
                                            ChunkUploadDatabaseService.saveChunkUploadData(this.f13997c);
                                            randomAccessFile.close();
                                        } else {
                                            z = false;
                                            if (!z) {
                                                rVar.f(this.f13998d.getServerErrorCode());
                                                rVar.g(this.f13998d.getErrorString());
                                                rVar.e(this.f13997c);
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

    /* renamed from: c.a.q0.s.g0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0688b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f14001a;

        /* renamed from: b  reason: collision with root package name */
        public String f14002b;

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
            this.f14001a = str;
            this.f14002b = str2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14001a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14002b : (String) invokeV.objValue;
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
        this.f13994f = new ArrayList();
        this.f13992d = str;
        this.f13993e = str2;
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            this.f13994f.add(new C0688b(this, str, String.valueOf(i2)));
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
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f13993e);
            this.f13989a = netWork;
            netWork.addPostData("voice_md5", qVar.b());
            if (ListUtils.getCount(this.f13994f) != 0) {
                for (C0688b c0688b : this.f13994f) {
                    if (c0688b != null) {
                        this.f13989a.addPostData(c0688b.a(), c0688b.b());
                    }
                }
            }
            String postNetData = this.f13989a.postNetData();
            if (postNetData != null && this.f13989a.getNetContext().getResponse().isRequestSuccess()) {
                ChunkUploadDatabaseService.delChunkUploadData(str);
                return postNetData;
            }
            qVar.d((int) b(qVar.c()));
            ChunkUploadDatabaseService.saveChunkUploadData(qVar);
            this.f13991c.f(this.f13989a.getServerErrorCode());
            this.f13991c.g(this.f13989a.getErrorString());
            this.f13991c.h(false);
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
                    this.f13989a = new NetWork(TbConfig.SERVER_ADDRESS + this.f13992d);
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
            a aVar = new a(this, str, qVar, TbConfig.SERVER_ADDRESS + this.f13992d, b2);
            this.f13990b = aVar;
            r a2 = aVar.a();
            this.f13991c = a2;
            if (a2.d() && (c2 = c(b2, qVar)) != null && !c2.equals("")) {
                AudioInfoData audioInfoData = new AudioInfoData();
                audioInfoData.parserJson(c2);
                if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                    qVar.e(audioInfoData.getVoiceId());
                    this.f13991c.e(qVar);
                } else {
                    this.f13991c.f(audioInfoData.getErrorCode());
                    this.f13991c.g(audioInfoData.getErrorUserMsg());
                    this.f13991c.h(false);
                }
            }
            return this.f13991c;
        }
        return (r) invokeLL.objValue;
    }
}
