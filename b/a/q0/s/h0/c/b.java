package b.a.q0.s.h0.c;

import b.a.e.f.p.q;
import b.a.q0.t.c.r;
import b.a.q0.t.c.s;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NetWork f13890a;

    /* renamed from: b  reason: collision with root package name */
    public a f13891b;

    /* renamed from: c  reason: collision with root package name */
    public s f13892c;

    /* renamed from: d  reason: collision with root package name */
    public String f13893d;

    /* renamed from: e  reason: collision with root package name */
    public String f13894e;

    /* renamed from: f  reason: collision with root package name */
    public List<C0719b> f13895f;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f13896a;

        /* renamed from: b  reason: collision with root package name */
        public String f13897b;

        /* renamed from: c  reason: collision with root package name */
        public r f13898c;

        /* renamed from: d  reason: collision with root package name */
        public NetWork f13899d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f13900e;

        /* renamed from: f  reason: collision with root package name */
        public String f13901f;

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
            this.f13896a = null;
            this.f13897b = null;
            this.f13898c = null;
            this.f13900e = false;
            this.f13901f = null;
            this.f13896a = str;
            this.f13898c = rVar;
            this.f13897b = str2;
            this.f13901f = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x00f6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0111 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public s a() throws IOException {
            InterceptResult invokeV;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                s sVar = new s();
                long c2 = this.f13898c.c();
                long j = 30720;
                long j2 = c2 / 30720;
                if (c2 % 30720 != 0) {
                    j2++;
                }
                int a2 = this.f13898c.a();
                if (a2 < j2) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f13896a), com.baidu.mapsdkplatform.comapi.map.r.f41000a);
                    int i2 = a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                    if (randomAccessFile.skipBytes(i2) >= i2) {
                        while (true) {
                            long j3 = a2;
                            if (j3 < j2) {
                                long j4 = j2 - 1;
                                int i3 = j3 == j4 ? (int) (c2 - (j4 * j)) : TbConfig.VOICE_CHUNK_UPLOAD_SIZE;
                                byte[] bArr = new byte[i3];
                                int read = randomAccessFile.read(bArr, 0, i3);
                                if (read != -1) {
                                    NetWork netWork = new NetWork(this.f13897b);
                                    this.f13899d = netWork;
                                    netWork.addPostData("voice_chunk", bArr);
                                    this.f13899d.addPostData("chunk_md5", this.f13898c.b());
                                    this.f13899d.addPostData(CloudStabilityUBCUtils.KEY_LENGTH, String.valueOf(read));
                                    this.f13899d.addPostData("offset", String.valueOf(a2 * TbConfig.VOICE_CHUNK_UPLOAD_SIZE));
                                    this.f13899d.addPostData("total_length", String.valueOf(c2));
                                    this.f13899d.addPostData("chunk_no", String.valueOf(a2 + 1));
                                    this.f13899d.addPostData("total_num", String.valueOf(j2));
                                    this.f13899d.addPostData("voice_md5", this.f13901f);
                                    if (!this.f13900e) {
                                        if (this.f13899d.postMultiNetData() == null || !this.f13899d.getNetContext().getResponse().isRequestSuccess()) {
                                            this.f13898c.d(a2);
                                            ChunkUploadDatabaseService.saveChunkUploadData(this.f13898c);
                                            randomAccessFile.close();
                                        } else {
                                            z = false;
                                            if (!z) {
                                                sVar.f(this.f13899d.getServerErrorCode());
                                                sVar.g(this.f13899d.getErrorString());
                                                sVar.e(this.f13898c);
                                                sVar.h(false);
                                                return sVar;
                                            }
                                        }
                                    }
                                    z = true;
                                    if (!z) {
                                    }
                                }
                                a2++;
                                j = 30720;
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

    /* renamed from: b.a.q0.s.h0.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0719b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f13902a;

        /* renamed from: b  reason: collision with root package name */
        public String f13903b;

        public C0719b(b bVar, String str, String str2) {
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
            this.f13902a = str;
            this.f13903b = str2;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f13902a : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13903b : (String) invokeV.objValue;
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
        this.f13895f = new ArrayList();
        this.f13893d = str;
        this.f13894e = str2;
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
            this.f13895f.add(new C0719b(this, str, String.valueOf(i2)));
        }
    }

    public final long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            int i2 = ((j % 30720) > 0L ? 1 : ((j % 30720) == 0L ? 0 : -1));
            long j2 = j / 30720;
            return i2 == 0 ? j2 : j2 + 1;
        }
        return invokeJ.longValue;
    }

    public final String c(String str, r rVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, rVar)) == null) {
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f13894e);
            this.f13890a = netWork;
            netWork.addPostData("voice_md5", rVar.b());
            if (ListUtils.getCount(this.f13895f) != 0) {
                for (C0719b c0719b : this.f13895f) {
                    if (c0719b != null) {
                        this.f13890a.addPostData(c0719b.a(), c0719b.b());
                    }
                }
            }
            String postNetData = this.f13890a.postNetData();
            if (postNetData != null && this.f13890a.getNetContext().getResponse().isRequestSuccess()) {
                ChunkUploadDatabaseService.delChunkUploadData(str);
                return postNetData;
            }
            rVar.d((int) b(rVar.c()));
            ChunkUploadDatabaseService.saveChunkUploadData(rVar);
            this.f13892c.f(this.f13890a.getServerErrorCode());
            this.f13892c.g(this.f13890a.getErrorString());
            this.f13892c.h(false);
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
                    this.f13890a = new NetWork(TbConfig.SERVER_ADDRESS + this.f13893d);
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
            String b2 = q.b(FileHelper.GetStreamFromFile(file));
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
            a aVar = new a(this, str, rVar, TbConfig.SERVER_ADDRESS + this.f13893d, b2);
            this.f13891b = aVar;
            s a2 = aVar.a();
            this.f13892c = a2;
            if (a2.d() && (c2 = c(b2, rVar)) != null && !c2.equals("")) {
                AudioInfoData audioInfoData = new AudioInfoData();
                audioInfoData.parserJson(c2);
                if (audioInfoData.getErrorCode() <= 0 && audioInfoData.getVoiceId() != null) {
                    rVar.e(audioInfoData.getVoiceId());
                    this.f13892c.e(rVar);
                } else {
                    this.f13892c.f(audioInfoData.getErrorCode());
                    this.f13892c.g(audioInfoData.getErrorUserMsg());
                    this.f13892c.h(false);
                }
            }
            return this.f13892c;
        }
        return (s) invokeLL.objValue;
    }
}
