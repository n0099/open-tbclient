package c.a.p0.c0;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.q;
import c.a.p0.s.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.UploadedImageInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12992a;

    /* renamed from: b  reason: collision with root package name */
    public int f12993b;

    /* renamed from: c  reason: collision with root package name */
    public int f12994c;

    /* renamed from: d  reason: collision with root package name */
    public int f12995d;

    /* renamed from: e  reason: collision with root package name */
    public int f12996e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12997f;

    /* renamed from: g  reason: collision with root package name */
    public String f12998g;

    /* renamed from: h  reason: collision with root package name */
    public NetWork f12999h;

    /* renamed from: i  reason: collision with root package name */
    public a f13000i;

    /* renamed from: j  reason: collision with root package name */
    public b f13001j;
    public Object k;
    public e l;
    public boolean m;
    public WriteData n;
    public WriteImagesInfo o;
    public int p;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, Object obj, long j2, long j3);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str, Object obj, long j2, long j3, int i2, int i3);
    }

    public f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12992a = 512000;
        this.f12998g = "1";
        this.f12999h = null;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12997f = true;
            NetWork netWork = this.f12999h;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f12992a = i2;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f12998g = str;
        }
    }

    public void d(a aVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, obj) == null) {
            this.f13000i = aVar;
            this.k = obj;
            if (aVar != null) {
                this.f12992a = 10240;
            }
        }
    }

    public void e(b bVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, obj) == null) {
            this.f13001j = bVar;
            this.k = obj;
        }
    }

    public void f(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            this.f12993b = i2;
            this.f12994c = i3;
            this.f12995d = i4;
            this.f12996e = i5;
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.p = i2;
        }
    }

    public void h(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, writeData) == null) {
            this.n = writeData;
        }
    }

    public ImageUploadResult i(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, imageFileInfo, z)) == null) ? j(imageFileInfo, false, z) : (ImageUploadResult) invokeLZ.objValue;
    }

    public ImageUploadResult j(ImageFileInfo imageFileInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? k(imageFileInfo, z, z2, 1, 1) : (ImageUploadResult) invokeCommon.objValue;
    }

    public final ImageUploadResult k(ImageFileInfo imageFileInfo, boolean z, boolean z2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new e();
            }
            return n(this.l.j(this.n, imageFileInfo, z), z, z2, i2, i3);
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    public ImageUploadResult l(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048587, this, str, z)) == null) ? m(str, false, z) : (ImageUploadResult) invokeLZ.objValue;
    }

    public ImageUploadResult m(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? n(str, z, z2, 1, 1) : (ImageUploadResult) invokeCommon.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:44|(15:48|49|(1:51)(1:286)|52|53|54|55|56|57|(2:58|(4:60|61|62|(1:264)(23:(1:65)(5:(2:257|258)(1:(2:242|243)(1:256))|(3:245|246|247)|254|255|249)|66|67|(5:223|224|225|226|227)(2:69|70)|71|72|(2:74|75)(1:221)|76|(1:80)|81|82|(1:84)|85|(1:87)(1:214)|88|89|(1:91)|(6:93|(1:95)|96|(1:100)|101|(6:103|(1:105)|106|(1:108)|109|(8:112|113|(3:193|194|(1:196))|115|(2:117|(2:121|122)(1:152))(10:153|(3:155|156|157)(1:192)|158|(1:160)|161|(5:177|178|179|180|181)(1:163)|164|165|(3:167|168|169)(1:171)|170)|123|124|(2:127|128)(1:126))(2:212|211)))|213|106|(0)|109|(1:212)(8:112|113|(0)|115|(0)(0)|123|124|(0)(0))))(1:271))|129|130|131|36|37)|287|288|289|291|292|293|131|36|37) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:(15:48|49|(1:51)(1:286)|52|53|54|55|56|57|(2:58|(4:60|61|62|(1:264)(23:(1:65)(5:(2:257|258)(1:(2:242|243)(1:256))|(3:245|246|247)|254|255|249)|66|67|(5:223|224|225|226|227)(2:69|70)|71|72|(2:74|75)(1:221)|76|(1:80)|81|82|(1:84)|85|(1:87)(1:214)|88|89|(1:91)|(6:93|(1:95)|96|(1:100)|101|(6:103|(1:105)|106|(1:108)|109|(8:112|113|(3:193|194|(1:196))|115|(2:117|(2:121|122)(1:152))(10:153|(3:155|156|157)(1:192)|158|(1:160)|161|(5:177|178|179|180|181)(1:163)|164|165|(3:167|168|169)(1:171)|170)|123|124|(2:127|128)(1:126))(2:212|211)))|213|106|(0)|109|(1:212)(8:112|113|(0)|115|(0)(0)|123|124|(0)(0))))(1:271))|129|130|131|36|37)|288|289|291|292|293|131|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x038a, code lost:
        r3 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x038c, code lost:
        r3.append("|startChunk=");
        r3.append(r7);
        c.a.q0.i3.r0.h.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x03a6, code lost:
        r15 = r4;
        r29 = r25;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03ac, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03ad, code lost:
        r2 = r0;
        r11 = r3;
        r7 = r4;
        r29 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x04c6, code lost:
        r15 = r4;
        r29 = r25;
        r11 = r27;
        r12 = null;
        r11.append("|startChunk=");
        r11.append(r7);
        r11.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x04db, code lost:
        if (r15 != null) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x04dd, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x04df, code lost:
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x04e0, code lost:
        r11.append(r9);
        r11.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x04e8, code lost:
        if (r15 == null) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x04ea, code lost:
        r11.append(r15.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x051c, code lost:
        r29 = r2;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0583, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0584, code lost:
        r2 = r0;
        r29 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x058d, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0170, code lost:
        r15.append("|startChunk=");
        r15.append(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01b1, code lost:
        if (r14.length != r9) goto L254;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:133:0x031b A[Catch: all -> 0x01fa, Exception -> 0x01fc, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x01fa, blocks: (B:75:0x01f2, B:95:0x022a, B:100:0x0269, B:102:0x026d, B:105:0x029f, B:108:0x02aa, B:114:0x02bf, B:116:0x02cc, B:118:0x02d6, B:119:0x02df, B:123:0x02ec, B:124:0x02f3, B:128:0x0304, B:133:0x031b, B:139:0x0334, B:146:0x0347, B:148:0x0367, B:151:0x036c, B:154:0x038c, B:161:0x03c0, B:166:0x03ce), top: B:287:0x01f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0347 A[Catch: all -> 0x01fa, Exception -> 0x033c, TRY_ENTER, TryCatch #15 {all -> 0x01fa, blocks: (B:75:0x01f2, B:95:0x022a, B:100:0x0269, B:102:0x026d, B:105:0x029f, B:108:0x02aa, B:114:0x02bf, B:116:0x02cc, B:118:0x02d6, B:119:0x02df, B:123:0x02ec, B:124:0x02f3, B:128:0x0304, B:133:0x031b, B:139:0x0334, B:146:0x0347, B:148:0x0367, B:151:0x036c, B:154:0x038c, B:161:0x03c0, B:166:0x03ce), top: B:287:0x01f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0498 A[LOOP:0: B:42:0x0165->B:192:0x0498, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x05a4 A[Catch: all -> 0x0632, TryCatch #10 {all -> 0x0632, blocks: (B:247:0x05a0, B:249:0x05a4, B:253:0x05b5, B:256:0x05c6, B:258:0x05ca, B:260:0x05d1, B:259:0x05cd, B:250:0x05aa, B:189:0x047b, B:191:0x0486, B:186:0x046d, B:199:0x04c6, B:203:0x04e0, B:205:0x04ea), top: B:281:0x047b }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x05aa A[Catch: all -> 0x0632, TryCatch #10 {all -> 0x0632, blocks: (B:247:0x05a0, B:249:0x05a4, B:253:0x05b5, B:256:0x05c6, B:258:0x05ca, B:260:0x05d1, B:259:0x05cd, B:250:0x05aa, B:189:0x047b, B:191:0x0486, B:186:0x046d, B:199:0x04c6, B:203:0x04e0, B:205:0x04ea), top: B:281:0x047b }] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x05b5 A[Catch: all -> 0x0632, TryCatch #10 {all -> 0x0632, blocks: (B:247:0x05a0, B:249:0x05a4, B:253:0x05b5, B:256:0x05c6, B:258:0x05ca, B:260:0x05d1, B:259:0x05cd, B:250:0x05aa, B:189:0x047b, B:191:0x0486, B:186:0x046d, B:199:0x04c6, B:203:0x04e0, B:205:0x04ea), top: B:281:0x047b }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x05c6 A[Catch: all -> 0x0632, TryCatch #10 {all -> 0x0632, blocks: (B:247:0x05a0, B:249:0x05a4, B:253:0x05b5, B:256:0x05c6, B:258:0x05ca, B:260:0x05d1, B:259:0x05cd, B:250:0x05aa, B:189:0x047b, B:191:0x0486, B:186:0x046d, B:199:0x04c6, B:203:0x04e0, B:205:0x04ea), top: B:281:0x047b }] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x05ca A[Catch: all -> 0x0632, TryCatch #10 {all -> 0x0632, blocks: (B:247:0x05a0, B:249:0x05a4, B:253:0x05b5, B:256:0x05c6, B:258:0x05ca, B:260:0x05d1, B:259:0x05cd, B:250:0x05aa, B:189:0x047b, B:191:0x0486, B:186:0x046d, B:199:0x04c6, B:203:0x04e0, B:205:0x04ea), top: B:281:0x047b }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x05cd A[Catch: all -> 0x0632, TryCatch #10 {all -> 0x0632, blocks: (B:247:0x05a0, B:249:0x05a4, B:253:0x05b5, B:256:0x05c6, B:258:0x05ca, B:260:0x05d1, B:259:0x05cd, B:250:0x05aa, B:189:0x047b, B:191:0x0486, B:186:0x046d, B:199:0x04c6, B:203:0x04e0, B:205:0x04ea), top: B:281:0x047b }] */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0334 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0486 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v17 */
    /* JADX WARN: Type inference failed for: r15v20 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v23 */
    /* JADX WARN: Type inference failed for: r15v9, types: [com.baidu.tbadk.img.ImageUploadResult] */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.baidu.tbadk.img.ImageUploadResult] */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r23v2 */
    /* JADX WARN: Type inference failed for: r23v3 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARN: Type inference failed for: r23v5 */
    /* JADX WARN: Type inference failed for: r23v6 */
    /* JADX WARN: Type inference failed for: r23v7 */
    /* JADX WARN: Type inference failed for: r23v8 */
    /* JADX WARN: Type inference failed for: r2v126, types: [com.baidu.tbadk.img.ImageUploadResult] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v31, types: [com.baidu.tbadk.img.ImageUploadResult] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.baidu.tbadk.img.ImageUploadResult] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.baidu.tbadk.img.ImageUploadResult] */
    /* JADX WARN: Type inference failed for: r7v6, types: [com.baidu.tbadk.img.ImageUploadResult] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult n(String str, boolean z, boolean z2, int i2, int i3) {
        InterceptResult invokeCommon;
        NetWork netWork;
        String str2;
        StringBuilder sb;
        char c2;
        Exception exc;
        RandomAccessFile randomAccessFile;
        Throwable th;
        ?? r23;
        String str3;
        ?? r4;
        File file;
        long length;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3;
        int i4;
        StringBuilder sb2;
        byte[] bArr;
        long j2;
        RandomAccessFile randomAccessFile4;
        RandomAccessFile randomAccessFile5;
        RandomAccessFile randomAccessFile6;
        String a2;
        String postMultiNetData;
        ?? parser;
        RandomAccessFile randomAccessFile7;
        long j3;
        BitmapFactory.Options options;
        byte[] bArr2;
        long j4;
        long j5;
        String str4;
        NetWork netWork2;
        int i5;
        int i6;
        RandomAccessFile randomAccessFile8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            String str5 = str;
            String str6 = "    p = ";
            c.a.q0.i3.r0.h.a("发帖：正在上传图片 = " + str5);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            boolean z3 = true;
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str5, options2);
            if (options2.outWidth != 0 && options2.outHeight != 0) {
                StringBuilder sb3 = new StringBuilder();
                RandomAccessFile randomAccessFile9 = null;
                RandomAccessFile randomAccessFile10 = null;
                RandomAccessFile randomAccessFile11 = null;
                NetWork netWork3 = null;
                try {
                    file = new File(str5);
                    length = file.length();
                    try {
                        try {
                        } catch (Exception e2) {
                            exc = e2;
                            randomAccessFile = null;
                            str2 = "    p = ";
                            sb = sb3;
                            c2 = 0;
                            netWork = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        netWork = null;
                    }
                } catch (Exception e3) {
                    str2 = "    p = ";
                    sb = sb3;
                    c2 = 0;
                    netWork = null;
                    exc = e3;
                } catch (Throwable th3) {
                    th = th3;
                    netWork = null;
                }
                if ((!z && length > 5242880) || (z && length > 10485760)) {
                    ?? imageUploadResult = new ImageUploadResult();
                    try {
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                        c.a.q0.i3.r0.h.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str5);
                        c.a.e.e.m.a.b(null);
                        this.f12999h = null;
                        return imageUploadResult;
                    } catch (Exception e4) {
                        e = e4;
                        randomAccessFile = null;
                        str2 = "    p = ";
                        sb = sb3;
                        c2 = 0;
                        randomAccessFile8 = imageUploadResult;
                        netWork = null;
                    }
                } else {
                    c.a.q0.i3.r0.h.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str5);
                    String b2 = q.b(FileHelper.GetStreamFromFile(file));
                    sb3.append("path=");
                    sb3.append(str5);
                    sb3.append("|length=");
                    sb3.append(length);
                    sb3.append("|md5=");
                    sb3.append(b2);
                    long j6 = 0;
                    try {
                        if (length != 0 && b2 != null) {
                            String str7 = b2 + this.f12992a;
                            long j7 = length % ((long) this.f12992a) == 0 ? length / this.f12992a : (length / this.f12992a) + 1;
                            sb3.append("|chunkNo=");
                            sb3.append(j7);
                            try {
                                RandomAccessFile randomAccessFile12 = new RandomAccessFile(str5, r.f42169a);
                                try {
                                    try {
                                        sb3.append("|width=");
                                        sb3.append(this.f12993b);
                                        sb3.append("|height=");
                                        sb3.append(this.f12994c);
                                        sb3.append("|smallWidth=");
                                        sb3.append(this.f12995d);
                                        sb3.append("|smallHeight=");
                                        sb3.append(this.f12996e);
                                        sb3.append("|groupId=");
                                        sb3.append(this.f12998g);
                                        int i7 = 1;
                                        int i8 = 0;
                                        r23 = null;
                                        byte[] bArr3 = null;
                                        while (true) {
                                            int i9 = (i7 > j7 ? 1 : (i7 == j7 ? 0 : -1));
                                            if (i9 > 0) {
                                                break;
                                            }
                                            try {
                                                if (this.f12997f == z3) {
                                                    break;
                                                }
                                                if (i9 > 0) {
                                                    j2 = j7;
                                                    sb2 = sb3;
                                                    i4 = 0;
                                                    bArr = null;
                                                } else {
                                                    if (i9 < 0) {
                                                        try {
                                                            try {
                                                                i4 = this.f12992a;
                                                                sb2 = sb3;
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                randomAccessFile9 = randomAccessFile12;
                                                                netWork = null;
                                                                th = th;
                                                                randomAccessFile11 = randomAccessFile9;
                                                                c.a.e.e.m.a.b(randomAccessFile11);
                                                                this.f12999h = netWork;
                                                                throw th;
                                                            }
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                            randomAccessFile = randomAccessFile12;
                                                            str2 = str6;
                                                            sb = sb3;
                                                            randomAccessFile3 = r23;
                                                            netWork = null;
                                                            c2 = 0;
                                                            randomAccessFile8 = randomAccessFile3;
                                                            exc = e;
                                                            randomAccessFile10 = randomAccessFile8;
                                                            if (!this.f12997f) {
                                                            }
                                                            if (randomAccessFile10 != null) {
                                                            }
                                                            if (r4 != null) {
                                                            }
                                                            if (r4 == null) {
                                                            }
                                                            Object[] objArr = new Object[2];
                                                            objArr[c2] = "comment";
                                                            objArr[1] = sb.toString();
                                                            c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr);
                                                            StringBuilder sb4 = new StringBuilder();
                                                            sb4.append("发帖：正在上传图片 上传失败 = ");
                                                            sb4.append(r3);
                                                            sb4.append(" ");
                                                            sb4.append(r2);
                                                            sb4.append(str2);
                                                            str3 = str;
                                                            sb4.append(str3);
                                                            c.a.q0.i3.r0.h.a(sb4.toString());
                                                            c.a.e.e.m.a.b(randomAccessFile);
                                                            this.f12999h = netWork;
                                                            r23 = r4;
                                                            c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str3);
                                                            return r23;
                                                        }
                                                    } else if (i9 == 0) {
                                                        sb2 = sb3;
                                                        i4 = (int) (length - (this.f12992a * (j7 - 1)));
                                                    } else {
                                                        sb2 = sb3;
                                                        i4 = 0;
                                                    }
                                                    if (bArr3 != null) {
                                                        bArr = bArr3;
                                                        try {
                                                        } catch (Exception e6) {
                                                            e = e6;
                                                            randomAccessFile = randomAccessFile12;
                                                            str2 = str6;
                                                            randomAccessFile3 = r23;
                                                            sb = sb2;
                                                            netWork = null;
                                                            c2 = 0;
                                                            randomAccessFile8 = randomAccessFile3;
                                                            exc = e;
                                                            randomAccessFile10 = randomAccessFile8;
                                                            if (!this.f12997f) {
                                                            }
                                                            if (randomAccessFile10 != null) {
                                                            }
                                                            if (r4 != null) {
                                                            }
                                                            if (r4 == null) {
                                                            }
                                                            Object[] objArr2 = new Object[2];
                                                            objArr2[c2] = "comment";
                                                            objArr2[1] = sb.toString();
                                                            c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr2);
                                                            StringBuilder sb42 = new StringBuilder();
                                                            sb42.append("发帖：正在上传图片 上传失败 = ");
                                                            sb42.append(r3);
                                                            sb42.append(" ");
                                                            sb42.append(r2);
                                                            sb42.append(str2);
                                                            str3 = str;
                                                            sb42.append(str3);
                                                            c.a.q0.i3.r0.h.a(sb42.toString());
                                                            c.a.e.e.m.a.b(randomAccessFile);
                                                            this.f12999h = netWork;
                                                            r23 = r4;
                                                            c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str3);
                                                            return r23;
                                                        }
                                                    }
                                                    try {
                                                        bArr = new byte[i4];
                                                        j2 = j7;
                                                        randomAccessFile12.seek(this.f12992a * (i7 - 1));
                                                        randomAccessFile12.read(bArr, 0, i4);
                                                    } catch (Exception e7) {
                                                        e = e7;
                                                        randomAccessFile = randomAccessFile12;
                                                        str2 = str6;
                                                        sb = sb2;
                                                        netWork = null;
                                                        c2 = 0;
                                                        exc = e;
                                                        randomAccessFile10 = r23;
                                                        if (!this.f12997f) {
                                                        }
                                                        if (randomAccessFile10 != null) {
                                                        }
                                                        if (r4 != null) {
                                                        }
                                                        if (r4 == null) {
                                                        }
                                                        Object[] objArr22 = new Object[2];
                                                        objArr22[c2] = "comment";
                                                        objArr22[1] = sb.toString();
                                                        c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr22);
                                                        StringBuilder sb422 = new StringBuilder();
                                                        sb422.append("发帖：正在上传图片 上传失败 = ");
                                                        sb422.append(r3);
                                                        sb422.append(" ");
                                                        sb422.append(r2);
                                                        sb422.append(str2);
                                                        str3 = str;
                                                        sb422.append(str3);
                                                        c.a.q0.i3.r0.h.a(sb422.toString());
                                                        c.a.e.e.m.a.b(randomAccessFile);
                                                        this.f12999h = netWork;
                                                        r23 = r4;
                                                        c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str3);
                                                        return r23;
                                                    }
                                                }
                                                NetWork netWork4 = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                                this.f12999h = netWork4;
                                                netWork4.addPostData("resourceId", str7);
                                                this.f12999h.addPostData("chunkNo", String.valueOf(i7));
                                                if (i9 >= 0) {
                                                    try {
                                                        randomAccessFile4 = randomAccessFile12;
                                                        try {
                                                            try {
                                                                this.f12999h.addPostData("isFinish", String.valueOf(1));
                                                            } catch (Throwable th5) {
                                                                th = th5;
                                                                th = th;
                                                                randomAccessFile6 = randomAccessFile4;
                                                                netWork = null;
                                                                randomAccessFile11 = randomAccessFile6;
                                                                c.a.e.e.m.a.b(randomAccessFile11);
                                                                this.f12999h = netWork;
                                                                throw th;
                                                            }
                                                        } catch (Exception e8) {
                                                            e = e8;
                                                            exc = e;
                                                            randomAccessFile5 = r23;
                                                            randomAccessFile = randomAccessFile4;
                                                            sb = sb2;
                                                            RandomAccessFile randomAccessFile13 = randomAccessFile5;
                                                            c2 = 0;
                                                            str2 = str6;
                                                            netWork = null;
                                                            randomAccessFile10 = randomAccessFile13;
                                                            if (!this.f12997f) {
                                                            }
                                                            if (randomAccessFile10 != null) {
                                                            }
                                                            if (r4 != null) {
                                                            }
                                                            if (r4 == null) {
                                                            }
                                                            Object[] objArr222 = new Object[2];
                                                            objArr222[c2] = "comment";
                                                            objArr222[1] = sb.toString();
                                                            c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr222);
                                                            StringBuilder sb4222 = new StringBuilder();
                                                            sb4222.append("发帖：正在上传图片 上传失败 = ");
                                                            sb4222.append(r3);
                                                            sb4222.append(" ");
                                                            sb4222.append(r2);
                                                            sb4222.append(str2);
                                                            str3 = str;
                                                            sb4222.append(str3);
                                                            c.a.q0.i3.r0.h.a(sb4222.toString());
                                                            c.a.e.e.m.a.b(randomAccessFile);
                                                            this.f12999h = netWork;
                                                            r23 = r4;
                                                            c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str3);
                                                            return r23;
                                                        }
                                                    } catch (Exception e9) {
                                                        e = e9;
                                                        randomAccessFile4 = randomAccessFile12;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        randomAccessFile4 = randomAccessFile12;
                                                        th = th;
                                                        randomAccessFile6 = randomAccessFile4;
                                                        netWork = null;
                                                        randomAccessFile11 = randomAccessFile6;
                                                        c.a.e.e.m.a.b(randomAccessFile11);
                                                        this.f12999h = netWork;
                                                        throw th;
                                                    }
                                                } else {
                                                    randomAccessFile4 = randomAccessFile12;
                                                    this.f12999h.addPostData("isFinish", String.valueOf(0));
                                                }
                                                if (this.m) {
                                                    this.f12999h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(1));
                                                } else {
                                                    this.f12999h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(0));
                                                }
                                                this.f12999h.addPostData("size", String.valueOf(length));
                                                this.f12999h.addPostData("width", String.valueOf(options2.outWidth));
                                                this.f12999h.addPostData("height", String.valueOf(options2.outHeight));
                                                if (this.f12995d > 0 && this.f12996e > 0) {
                                                    this.f12999h.addPostData("smallWidth", String.valueOf(this.f12995d));
                                                    this.f12999h.addPostData("smallHeight", String.valueOf(this.f12996e));
                                                }
                                                try {
                                                    try {
                                                        this.f12999h.addPostData(TbEnum.SystemMessage.KEY_GROUP_ID, String.valueOf(this.f12998g));
                                                        this.f12999h.addPostData("alt", "json");
                                                        if (bArr != null) {
                                                            this.f12999h.addPostData("chunk", bArr);
                                                        }
                                                        if (z) {
                                                            this.f12999h.addPostData("saveOrigin", "1");
                                                        } else {
                                                            this.f12999h.addPostData("saveOrigin", "0");
                                                        }
                                                        if (this.p != 0) {
                                                            this.f12999h.addPostData("pic_water_type", String.valueOf(this.p));
                                                        }
                                                        if (z2) {
                                                            int b3 = k.c().b();
                                                            if (b3 != 0) {
                                                                this.f12999h.addPostData("pic_water_type", String.valueOf(b3));
                                                            }
                                                            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                            if (!StringUtils.isNull(currentAccountName) && b3 == 1) {
                                                                this.f12999h.addPostData("user_name", currentAccountName);
                                                            }
                                                            String a3 = k.c().a();
                                                            if (!StringUtils.isNull(a3)) {
                                                                if (b3 == 2) {
                                                                    this.f12999h.addPostData("forum_name", a3);
                                                                }
                                                                a2 = k.c().a();
                                                                if (!StringUtils.isNull(a2)) {
                                                                    this.f12999h.addPostData("small_flow_fname", a2);
                                                                }
                                                                postMultiNetData = this.f12999h.postMultiNetData();
                                                                parser = ImageUploadResult.parser(postMultiNetData);
                                                                if (postMultiNetData != null || parser == null) {
                                                                    break;
                                                                    break;
                                                                }
                                                                try {
                                                                    if (parser.error_code != 0) {
                                                                        try {
                                                                            if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                                                break;
                                                                            }
                                                                        } catch (Exception e10) {
                                                                            exc = e10;
                                                                            randomAccessFile5 = parser;
                                                                            randomAccessFile = randomAccessFile4;
                                                                            sb = sb2;
                                                                            RandomAccessFile randomAccessFile132 = randomAccessFile5;
                                                                            c2 = 0;
                                                                            str2 = str6;
                                                                            netWork = null;
                                                                            randomAccessFile10 = randomAccessFile132;
                                                                            if (!this.f12997f) {
                                                                            }
                                                                            if (randomAccessFile10 != null) {
                                                                            }
                                                                            if (r4 != null) {
                                                                            }
                                                                            if (r4 == null) {
                                                                            }
                                                                            Object[] objArr2222 = new Object[2];
                                                                            objArr2222[c2] = "comment";
                                                                            objArr2222[1] = sb.toString();
                                                                            c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr2222);
                                                                            StringBuilder sb42222 = new StringBuilder();
                                                                            sb42222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb42222.append(r3);
                                                                            sb42222.append(" ");
                                                                            sb42222.append(r2);
                                                                            sb42222.append(str2);
                                                                            str3 = str;
                                                                            sb42222.append(str3);
                                                                            c.a.q0.i3.r0.h.a(sb42222.toString());
                                                                            c.a.e.e.m.a.b(randomAccessFile);
                                                                            this.f12999h = netWork;
                                                                            r23 = r4;
                                                                            c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str3);
                                                                            return r23;
                                                                        }
                                                                    }
                                                                    if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                                        c.a.q0.i3.r0.h.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + parser.error_code + str6 + str5);
                                                                        if (i7 == parser.chunkNo || parser.chunkNo <= 0) {
                                                                            break;
                                                                        }
                                                                        i7 = parser.chunkNo;
                                                                        randomAccessFile7 = parser;
                                                                        j5 = length;
                                                                        str4 = str7;
                                                                        sb = sb2;
                                                                        c2 = 0;
                                                                        options = options2;
                                                                        RandomAccessFile randomAccessFile14 = randomAccessFile4;
                                                                        str2 = str6;
                                                                        netWork = null;
                                                                        long j8 = j2;
                                                                        bArr2 = bArr;
                                                                        randomAccessFile = randomAccessFile14;
                                                                        j4 = j8;
                                                                    } else {
                                                                        int i10 = i7 + 1;
                                                                        j6 += i4;
                                                                        long j9 = i10 > 1 ? j6 + ((i10 - 1) * this.f12992a) : j6;
                                                                        if (this.o != null) {
                                                                            this.o.hasUploadFileSize += i4;
                                                                        }
                                                                        c.a.q0.i3.r0.h.a("发帖：正在上传图片 已上传 = " + j9 + str6 + str5);
                                                                        if (this.f13000i != null) {
                                                                            try {
                                                                                RandomAccessFile randomAccessFile15 = randomAccessFile4;
                                                                                j3 = j9;
                                                                                StringBuilder sb5 = sb2;
                                                                                options = options2;
                                                                                long j10 = j2;
                                                                                bArr2 = bArr;
                                                                                j4 = j10;
                                                                                randomAccessFile = randomAccessFile15;
                                                                                randomAccessFile7 = parser;
                                                                                j5 = length;
                                                                                sb = sb5;
                                                                                str4 = str7;
                                                                                netWork2 = null;
                                                                            } catch (Exception e11) {
                                                                                randomAccessFile = randomAccessFile4;
                                                                                sb = sb2;
                                                                                exc = e11;
                                                                                str2 = str6;
                                                                                randomAccessFile10 = parser;
                                                                                netWork = null;
                                                                                c2 = 0;
                                                                            } catch (Throwable th7) {
                                                                                th = th7;
                                                                                randomAccessFile6 = randomAccessFile4;
                                                                                netWork = null;
                                                                                randomAccessFile11 = randomAccessFile6;
                                                                                c.a.e.e.m.a.b(randomAccessFile11);
                                                                                this.f12999h = netWork;
                                                                                throw th;
                                                                            }
                                                                            try {
                                                                                this.f13000i.a(str, this.k, j3, j5);
                                                                            } catch (Exception e12) {
                                                                                exc = e12;
                                                                                str2 = str6;
                                                                                randomAccessFile10 = randomAccessFile7;
                                                                                c2 = 0;
                                                                                netWork = null;
                                                                            } catch (Throwable th8) {
                                                                                th = th8;
                                                                                netWork = null;
                                                                                randomAccessFile11 = randomAccessFile;
                                                                                c.a.e.e.m.a.b(randomAccessFile11);
                                                                                this.f12999h = netWork;
                                                                                throw th;
                                                                            }
                                                                        } else {
                                                                            randomAccessFile7 = parser;
                                                                            j5 = length;
                                                                            str4 = str7;
                                                                            sb = sb2;
                                                                            netWork2 = null;
                                                                            options = options2;
                                                                            long j11 = j2;
                                                                            bArr2 = bArr;
                                                                            randomAccessFile = randomAccessFile4;
                                                                            j4 = j11;
                                                                            j3 = j9;
                                                                        }
                                                                        try {
                                                                            if (this.f13001j != null) {
                                                                                long j12 = j3;
                                                                                str2 = str6;
                                                                                c2 = 0;
                                                                                netWork = netWork2;
                                                                                i5 = i10;
                                                                                this.f13001j.a(str, this.k, j12, j5, i2, i3);
                                                                            } else {
                                                                                i5 = i10;
                                                                                str2 = str6;
                                                                                c2 = 0;
                                                                                netWork = netWork2;
                                                                            }
                                                                            i7 = i5;
                                                                        } catch (Exception e13) {
                                                                            e = e13;
                                                                            str2 = str6;
                                                                            c2 = 0;
                                                                            netWork = netWork2;
                                                                            exc = e;
                                                                            randomAccessFile10 = randomAccessFile7;
                                                                            if (!this.f12997f) {
                                                                            }
                                                                            if (randomAccessFile10 != null) {
                                                                            }
                                                                            if (r4 != null) {
                                                                            }
                                                                            if (r4 == null) {
                                                                            }
                                                                            Object[] objArr22222 = new Object[2];
                                                                            objArr22222[c2] = "comment";
                                                                            objArr22222[1] = sb.toString();
                                                                            c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr22222);
                                                                            StringBuilder sb422222 = new StringBuilder();
                                                                            sb422222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb422222.append(r3);
                                                                            sb422222.append(" ");
                                                                            sb422222.append(r2);
                                                                            sb422222.append(str2);
                                                                            str3 = str;
                                                                            sb422222.append(str3);
                                                                            c.a.q0.i3.r0.h.a(sb422222.toString());
                                                                            c.a.e.e.m.a.b(randomAccessFile);
                                                                            this.f12999h = netWork;
                                                                            r23 = r4;
                                                                            c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str3);
                                                                            return r23;
                                                                        } catch (Throwable th9) {
                                                                            th = th9;
                                                                            netWork = netWork2;
                                                                            th = th;
                                                                            randomAccessFile11 = randomAccessFile;
                                                                            c.a.e.e.m.a.b(randomAccessFile11);
                                                                            this.f12999h = netWork;
                                                                            throw th;
                                                                        }
                                                                    }
                                                                    try {
                                                                        try {
                                                                            i6 = i8 + 1;
                                                                            if (i6 <= 2 * j4) {
                                                                                sb.append("|possbile dead loop found. tryCount=");
                                                                                sb.append(i6);
                                                                                sb.append(", chunkNo=");
                                                                                sb.append(j4);
                                                                                break;
                                                                            }
                                                                            i8 = i6;
                                                                            j7 = j4;
                                                                            r23 = randomAccessFile7;
                                                                            str7 = str4;
                                                                            str6 = str2;
                                                                            options2 = options;
                                                                            bArr3 = bArr2;
                                                                            randomAccessFile12 = randomAccessFile;
                                                                            length = j5;
                                                                            z3 = true;
                                                                            sb3 = sb;
                                                                            str5 = str;
                                                                        } catch (Exception e14) {
                                                                            e = e14;
                                                                            exc = e;
                                                                            randomAccessFile10 = randomAccessFile7;
                                                                            if (!this.f12997f) {
                                                                            }
                                                                            if (randomAccessFile10 != null) {
                                                                            }
                                                                            if (r4 != null) {
                                                                            }
                                                                            if (r4 == null) {
                                                                            }
                                                                            Object[] objArr222222 = new Object[2];
                                                                            objArr222222[c2] = "comment";
                                                                            objArr222222[1] = sb.toString();
                                                                            c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr222222);
                                                                            StringBuilder sb4222222 = new StringBuilder();
                                                                            sb4222222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb4222222.append(r3);
                                                                            sb4222222.append(" ");
                                                                            sb4222222.append(r2);
                                                                            sb4222222.append(str2);
                                                                            str3 = str;
                                                                            sb4222222.append(str3);
                                                                            c.a.q0.i3.r0.h.a(sb4222222.toString());
                                                                            c.a.e.e.m.a.b(randomAccessFile);
                                                                            this.f12999h = netWork;
                                                                            r23 = r4;
                                                                            c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str3);
                                                                            return r23;
                                                                        }
                                                                    } catch (Throwable th10) {
                                                                        th = th10;
                                                                        th = th;
                                                                        randomAccessFile11 = randomAccessFile;
                                                                        c.a.e.e.m.a.b(randomAccessFile11);
                                                                        this.f12999h = netWork;
                                                                        throw th;
                                                                    }
                                                                } catch (Exception e15) {
                                                                    e = e15;
                                                                    randomAccessFile7 = parser;
                                                                    randomAccessFile = randomAccessFile4;
                                                                    sb = sb2;
                                                                    c2 = 0;
                                                                    str2 = str6;
                                                                    netWork = null;
                                                                }
                                                            }
                                                        }
                                                        a2 = k.c().a();
                                                        if (!StringUtils.isNull(a2)) {
                                                        }
                                                        postMultiNetData = this.f12999h.postMultiNetData();
                                                        parser = ImageUploadResult.parser(postMultiNetData);
                                                        if (postMultiNetData != null) {
                                                            break;
                                                        }
                                                        if (parser.error_code != 0) {
                                                        }
                                                        if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                        }
                                                        i6 = i8 + 1;
                                                        if (i6 <= 2 * j4) {
                                                        }
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                        randomAccessFile = randomAccessFile4;
                                                        netWork = null;
                                                        th = th;
                                                        randomAccessFile11 = randomAccessFile;
                                                        c.a.e.e.m.a.b(randomAccessFile11);
                                                        this.f12999h = netWork;
                                                        throw th;
                                                    }
                                                } catch (Exception e16) {
                                                    e = e16;
                                                    randomAccessFile = randomAccessFile4;
                                                    sb = sb2;
                                                    c2 = 0;
                                                    str2 = str6;
                                                    netWork = null;
                                                    exc = e;
                                                    randomAccessFile10 = r23;
                                                    if (!this.f12997f) {
                                                    }
                                                    if (randomAccessFile10 != null) {
                                                    }
                                                    if (r4 != null) {
                                                    }
                                                    if (r4 == null) {
                                                    }
                                                    Object[] objArr2222222 = new Object[2];
                                                    objArr2222222[c2] = "comment";
                                                    objArr2222222[1] = sb.toString();
                                                    c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr2222222);
                                                    StringBuilder sb42222222 = new StringBuilder();
                                                    sb42222222.append("发帖：正在上传图片 上传失败 = ");
                                                    sb42222222.append(r3);
                                                    sb42222222.append(" ");
                                                    sb42222222.append(r2);
                                                    sb42222222.append(str2);
                                                    str3 = str;
                                                    sb42222222.append(str3);
                                                    c.a.q0.i3.r0.h.a(sb42222222.toString());
                                                    c.a.e.e.m.a.b(randomAccessFile);
                                                    this.f12999h = netWork;
                                                    r23 = r4;
                                                    c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str3);
                                                    return r23;
                                                }
                                            } catch (Exception e17) {
                                                e = e17;
                                                randomAccessFile = randomAccessFile12;
                                                str2 = str6;
                                                sb = sb3;
                                            }
                                        }
                                        r23 = randomAccessFile7;
                                        randomAccessFile2 = randomAccessFile;
                                        c.a.e.e.m.a.b(randomAccessFile2);
                                        this.f12999h = netWork;
                                        str3 = str;
                                    } catch (Throwable th12) {
                                        th = th12;
                                        randomAccessFile = randomAccessFile12;
                                    }
                                } catch (Exception e18) {
                                    randomAccessFile = randomAccessFile12;
                                    str2 = "    p = ";
                                    sb = sb3;
                                    netWork = null;
                                    c2 = 0;
                                    exc = e18;
                                    randomAccessFile10 = null;
                                }
                            } catch (Exception e19) {
                                e = e19;
                                str2 = "    p = ";
                                sb = sb3;
                                netWork = null;
                                c2 = 0;
                                exc = e;
                                netWork3 = netWork;
                                randomAccessFile = netWork3;
                                randomAccessFile10 = netWork3;
                                if (!this.f12997f) {
                                }
                                if (randomAccessFile10 != null) {
                                }
                                if (r4 != null) {
                                }
                                if (r4 == null) {
                                }
                                Object[] objArr22222222 = new Object[2];
                                objArr22222222[c2] = "comment";
                                objArr22222222[1] = sb.toString();
                                c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr22222222);
                                StringBuilder sb422222222 = new StringBuilder();
                                sb422222222.append("发帖：正在上传图片 上传失败 = ");
                                sb422222222.append(r3);
                                sb422222222.append(" ");
                                sb422222222.append(r2);
                                sb422222222.append(str2);
                                str3 = str;
                                sb422222222.append(str3);
                                c.a.q0.i3.r0.h.a(sb422222222.toString());
                                c.a.e.e.m.a.b(randomAccessFile);
                                this.f12999h = netWork;
                                r23 = r4;
                                c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str3);
                                return r23;
                            } catch (Throwable th13) {
                                th = th13;
                                netWork = null;
                                th = th;
                                randomAccessFile11 = netWork;
                                c.a.e.e.m.a.b(randomAccessFile11);
                                this.f12999h = netWork;
                                throw th;
                            }
                            c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str3);
                            return r23;
                        }
                        ?? imageUploadResult2 = new ImageUploadResult();
                        imageUploadResult2.error_code = -1007;
                        imageUploadResult2.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_not_exist);
                        TiebaStatic.imgError(-1007, "file error: " + imageUploadResult2.error_msg, sb.toString());
                        r23 = imageUploadResult2;
                        randomAccessFile2 = null;
                        c.a.e.e.m.a.b(randomAccessFile2);
                        this.f12999h = netWork;
                        str3 = str;
                        c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str3);
                        return r23;
                    } catch (Throwable th14) {
                        th = th14;
                        th = th;
                        randomAccessFile11 = netWork;
                        c.a.e.e.m.a.b(randomAccessFile11);
                        this.f12999h = netWork;
                        throw th;
                    }
                    str2 = "    p = ";
                    sb = sb3;
                    c2 = 0;
                    netWork = null;
                }
                exc = e;
                randomAccessFile10 = randomAccessFile8;
                if (!this.f12997f) {
                    sb.append("|request cancelled.");
                } else {
                    BdLog.e(exc.getMessage());
                }
                if (randomAccessFile10 != null) {
                    r4 = new ImageUploadResult();
                    r4.error_code = -1002;
                    r4.error_msg = exc.getMessage();
                } else {
                    r4 = randomAccessFile10;
                }
                int i11 = r4 != null ? r4.error_code : -1002;
                String message = r4 == null ? r4.error_msg : exc.getMessage();
                Object[] objArr222222222 = new Object[2];
                objArr222222222[c2] = "comment";
                objArr222222222[1] = sb.toString();
                c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", i11, message, objArr222222222);
                StringBuilder sb4222222222 = new StringBuilder();
                sb4222222222.append("发帖：正在上传图片 上传失败 = ");
                sb4222222222.append(i11);
                sb4222222222.append(" ");
                sb4222222222.append(message);
                sb4222222222.append(str2);
                str3 = str;
                sb4222222222.append(str3);
                c.a.q0.i3.r0.h.a(sb4222222222.toString());
                c.a.e.e.m.a.b(randomAccessFile);
                this.f12999h = netWork;
                r23 = r4;
                c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str3);
                return r23;
            }
            c.a.q0.i3.r0.h.a("发帖：正在上传图片 失败 = " + str5);
            ImageUploadResult imageUploadResult3 = new ImageUploadResult();
            imageUploadResult3.error_code = -1007;
            imageUploadResult3.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
            return imageUploadResult3;
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    public void o(WriteImagesInfo writeImagesInfo, boolean z) {
        UploadedImageInfo uploadedPicInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048590, this, writeImagesInfo, z) == null) || writeImagesInfo == null || writeImagesInfo.size() == 0) {
            return;
        }
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        for (int i2 = 0; i2 < chosedFiles.size(); i2++) {
            ImageFileInfo imageFileInfo = chosedFiles.get(i2);
            if (imageFileInfo != null && !imageFileInfo.isAlreadyUploadedToServer()) {
                if (this.f12997f) {
                    return;
                }
                ImageUploadResult j2 = j(imageFileInfo, writeImagesInfo.isOriginalImg() || imageFileInfo.isGif(), z);
                if (j2 != null && (uploadedPicInfo = j2.getUploadedPicInfo()) != null) {
                    imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                    imageFileInfo.serverPicInfo = j2.picInfo;
                }
            }
        }
    }

    public ErrorData p(WriteImagesInfo writeImagesInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, writeImagesInfo, z)) == null) {
            f fVar = this;
            c.a.q0.i3.r0.h.a("发帖： 上传批量图片到server");
            ErrorData errorData = new ErrorData();
            if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
                LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
                fVar.o = writeImagesInfo;
                int i2 = 0;
                writeImagesInfo.allImageFileSize = 0;
                writeImagesInfo.hasUploadFileSize = 0;
                LinkedList linkedList = new LinkedList();
                for (int i3 = 0; i3 < chosedFiles.size(); i3++) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i3);
                    if (!imageFileInfo.isAlreadyUploadedToServer()) {
                        File file = new File(imageFileInfo.getFilePath());
                        if (imageFileInfo.getImageType() == 1) {
                            linkedList.add(imageFileInfo);
                        } else if (file.exists()) {
                            writeImagesInfo.allImageFileSize = (int) (writeImagesInfo.allImageFileSize + file.length());
                            linkedList.add(imageFileInfo);
                        }
                    }
                }
                if (fVar.n.getAsyncPublishStatData() != null && fVar.n.startPublishTime() > 0 && writeImagesInfo.needImageParallel) {
                    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(writeImagesInfo.imageUploadConcurrency);
                    h hVar = new h();
                    ArrayList<FutureTask<Boolean>> arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    while (i2 < linkedList.size()) {
                        g gVar = new g(hVar, linkedList, writeImagesInfo, z, i2);
                        gVar.d(fVar.n);
                        gVar.c(fVar.f12992a, fVar.f12993b, fVar.f12994c, fVar.f12995d, fVar.f12996e, fVar.f12997f, fVar.p, fVar.f12998g, fVar.f13000i, fVar.f13001j, fVar.k, fVar.m);
                        arrayList2.add(gVar);
                        arrayList.add(new FutureTask<>(gVar));
                        i2++;
                        fVar = this;
                        linkedList = linkedList;
                        newFixedThreadPool = newFixedThreadPool;
                        hVar = hVar;
                    }
                    ExecutorService executorService = newFixedThreadPool;
                    h hVar2 = hVar;
                    hVar2.c(arrayList);
                    hVar2.b(arrayList2);
                    for (FutureTask<Boolean> futureTask : arrayList) {
                        executorService.submit(futureTask);
                    }
                    for (FutureTask<Boolean> futureTask2 : arrayList) {
                        try {
                            futureTask2.get();
                        } catch (Exception unused) {
                        }
                    }
                    executorService.shutdown();
                    return hVar2.f13010c;
                }
                LinkedList linkedList2 = linkedList;
                int i4 = 0;
                while (i4 < linkedList2.size()) {
                    LinkedList linkedList3 = linkedList2;
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) linkedList3.get(i4);
                    imageFileInfo2.setTempUploadFileName(null);
                    c.a.q0.i3.r0.h.a("发帖：发送图片 上传图片 = " + i4 + " = " + imageFileInfo2.toJson().toString());
                    if (this.f12997f) {
                        break;
                    }
                    boolean isOriginalImg = imageFileInfo2.getImageType() == 1 ? false : writeImagesInfo.isOriginalImg();
                    c.a.q0.i3.r0.d.m(this.n, imageFileInfo2);
                    int i5 = i4 + 1;
                    ImageUploadResult k = k(imageFileInfo2, isOriginalImg, z, i5, linkedList3.size());
                    c.a.q0.i3.r0.d.d(this.n, imageFileInfo2, k);
                    if (k != null) {
                        UploadedImageInfo uploadedPicInfo = k.getUploadedPicInfo();
                        if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                            uploadedPicInfo.isGif = imageFileInfo2.isGif();
                            uploadedPicInfo.isBJH = this.m;
                            imageFileInfo2.setServerImageCode(uploadedPicInfo.toPostString());
                            linkedList2 = linkedList3;
                            i4 = i5;
                        } else {
                            errorData.setError_code(k.error_code);
                            errorData.setError_msg(k.error_msg);
                            c.a.q0.i3.r0.h.a("发帖：发送图片 上传图片 错误 1= " + i4 + " = " + imageFileInfo2.toJson().toString());
                            return errorData;
                        }
                    } else {
                        errorData.setError_code(-52);
                        errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        c.a.q0.i3.r0.h.a("发帖：发送图片 上传图片 错误 2= " + i4 + " = " + imageFileInfo2.toJson().toString());
                        return errorData;
                    }
                }
                c.a.q0.i3.r0.h.a("发帖：发送图片 上传图片 成功返回");
                return null;
            }
            errorData.setError_code(-1002);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
            c.a.q0.i3.r0.h.a("发帖：发送图片 上传图片 错误 无图");
            return errorData;
        }
        return (ErrorData) invokeLZ.objValue;
    }
}
