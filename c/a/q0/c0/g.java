package c.a.q0.c0;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import c.a.d.f.p.t;
import c.a.q0.c0.f;
import c.a.q0.r.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import java.util.LinkedList;
import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
public class g implements Callable<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h f12144e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<ImageFileInfo> f12145f;

    /* renamed from: g  reason: collision with root package name */
    public WriteImagesInfo f12146g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12147h;

    /* renamed from: i  reason: collision with root package name */
    public int f12148i;

    /* renamed from: j  reason: collision with root package name */
    public int f12149j;
    public int k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public String q;
    public f.a r;
    public f.b s;
    public Object t;
    public boolean u;
    public int v;
    public NetWork w;
    public e x;
    public WriteData y;

    public g(h hVar, LinkedList<ImageFileInfo> linkedList, WriteImagesInfo writeImagesInfo, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar, linkedList, writeImagesInfo, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = null;
        this.f12144e = hVar;
        this.f12145f = linkedList;
        this.f12146g = writeImagesInfo;
        this.f12147h = z;
        this.f12148i = i2;
    }

    public void a() {
        NetWork netWork;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (netWork = this.w) == null) {
            return;
        }
        netWork.cancelNetConnect();
    }

    public void b(int i2, int i3, int i4, int i5, int i6, boolean z, int i7, String str, f.a aVar, f.b bVar, Object obj, boolean z2, int i8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), Integer.valueOf(i7), str, aVar, bVar, obj, Boolean.valueOf(z2), Integer.valueOf(i8)}) == null) {
            this.f12149j = i2;
            this.k = i3;
            this.l = i4;
            this.m = i5;
            this.n = i6;
            this.o = z;
            this.p = i7;
            this.q = str;
            this.r = aVar;
            this.s = bVar;
            this.t = obj;
            this.u = z2;
            this.v = i8;
        }
    }

    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
            this.y = writeData;
        }
    }

    public final ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z, boolean z2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.x == null) {
                this.x = new e();
            }
            return e(this.x.j(this.y, imageFileInfo, z), z, z2, i2, i3);
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:43|(13:47|48|(1:50)(1:292)|51|52|53|54|(2:55|(6:57|58|59|(1:270)(24:61|(1:63)(5:(2:265|266)(1:(2:252|253)(1:264))|(2:258|259)|255|256|257)|64|65|(5:231|232|233|234|235)(2:67|68)|69|70|(2:72|73)(1:229)|74|(1:78)|79|80|(1:82)|83|(1:85)(1:221)|86|87|(1:89)|(6:91|(1:93)|94|(1:98)|99|(6:101|(1:103)|104|(1:106)|107|(5:110|111|(3:192|193|(1:195))|113|(2:115|(5:119|120|121|122|(2:125|126)(1:124))(1:145))(7:146|147|148|(1:150)(10:151|(4:153|154|155|156)(1:187)|157|(1:159)(1:186)|160|(5:174|175|176|177|178)(1:162)|163|164|(3:166|167|168)(1:170)|169)|121|122|(0)(0)))(2:219|218)))|220|104|(0)|107|(1:219)(5:110|111|(0)|113|(0)(0)))|36|37)(2:284|285))|127|128|129|36|37)|293|294|295|296|297|298|299|129|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0393, code lost:
        r8 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0397, code lost:
        r8.append(r27);
        r8.append(r4);
        c.a.r0.y3.t0.c.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03b1, code lost:
        r11 = r7;
        r29 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x04d3, code lost:
        r11 = r7;
        r29 = r17;
        r15 = r26;
        r16 = 0;
        r15.append(r27);
        r15.append(r4);
        r15.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x04e7, code lost:
        if (r11 != null) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x04e9, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x04eb, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x04ec, code lost:
        r15.append(r7);
        r15.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x04f4, code lost:
        if (r11 == null) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04f6, code lost:
        r15.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x04fb, code lost:
        if (r11 != null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x04fd, code lost:
        r3 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0503, code lost:
        r3.error_code = -7;
        r3.error_msg = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0508, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0584, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0585, code lost:
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x0587, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0592, code lost:
        r3 = r0;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:257:0x0594, code lost:
        r29 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0165, code lost:
        r9 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0167, code lost:
        r9.append("|startChunk=");
        r9.append(r4);
        r4 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0174, code lost:
        r4.error_code = -54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0176, code lost:
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0179, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x017a, code lost:
        r3 = r0;
        r29 = r2;
        r2 = r4;
        r15 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01bf, code lost:
        if (r15.length != r10) goto L255;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x031e A[Catch: all -> 0x0207, Exception -> 0x020d, TRY_ENTER, TRY_LEAVE, TryCatch #10 {Exception -> 0x020d, blocks: (B:82:0x01ff, B:98:0x022d, B:103:0x026c, B:105:0x0270, B:108:0x02a2, B:111:0x02ad, B:117:0x02c2, B:119:0x02cf, B:121:0x02d9, B:122:0x02e2, B:126:0x02ef, B:127:0x02f6, B:131:0x0307, B:136:0x031e), top: B:299:0x01ff }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0351 A[Catch: all -> 0x0207, Exception -> 0x0342, TRY_ENTER, TryCatch #14 {all -> 0x0207, blocks: (B:82:0x01ff, B:98:0x022d, B:103:0x026c, B:105:0x0270, B:108:0x02a2, B:111:0x02ad, B:117:0x02c2, B:119:0x02cf, B:121:0x02d9, B:122:0x02e2, B:126:0x02ef, B:127:0x02f6, B:131:0x0307, B:136:0x031e, B:142:0x0338, B:149:0x0351, B:151:0x0371, B:154:0x0376, B:157:0x0397, B:166:0x03e2, B:173:0x03f8), top: B:299:0x01ff }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04ab A[LOOP:0: B:41:0x015a->B:198:0x04ab, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x059a A[Catch: all -> 0x0623, TryCatch #0 {all -> 0x0623, blocks: (B:258:0x0596, B:260:0x059a, B:264:0x05ab, B:266:0x05ba, B:268:0x05be, B:270:0x05c5, B:269:0x05c1, B:261:0x05a0, B:195:0x0495, B:197:0x0499, B:180:0x0444, B:188:0x046f, B:190:0x0473, B:192:0x0489, B:206:0x04d3, B:210:0x04ec, B:212:0x04f6, B:214:0x04fd, B:216:0x0503), top: B:284:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x05a0 A[Catch: all -> 0x0623, TryCatch #0 {all -> 0x0623, blocks: (B:258:0x0596, B:260:0x059a, B:264:0x05ab, B:266:0x05ba, B:268:0x05be, B:270:0x05c5, B:269:0x05c1, B:261:0x05a0, B:195:0x0495, B:197:0x0499, B:180:0x0444, B:188:0x046f, B:190:0x0473, B:192:0x0489, B:206:0x04d3, B:210:0x04ec, B:212:0x04f6, B:214:0x04fd, B:216:0x0503), top: B:284:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x05ab A[Catch: all -> 0x0623, TryCatch #0 {all -> 0x0623, blocks: (B:258:0x0596, B:260:0x059a, B:264:0x05ab, B:266:0x05ba, B:268:0x05be, B:270:0x05c5, B:269:0x05c1, B:261:0x05a0, B:195:0x0495, B:197:0x0499, B:180:0x0444, B:188:0x046f, B:190:0x0473, B:192:0x0489, B:206:0x04d3, B:210:0x04ec, B:212:0x04f6, B:214:0x04fd, B:216:0x0503), top: B:284:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x05ba A[Catch: all -> 0x0623, TryCatch #0 {all -> 0x0623, blocks: (B:258:0x0596, B:260:0x059a, B:264:0x05ab, B:266:0x05ba, B:268:0x05be, B:270:0x05c5, B:269:0x05c1, B:261:0x05a0, B:195:0x0495, B:197:0x0499, B:180:0x0444, B:188:0x046f, B:190:0x0473, B:192:0x0489, B:206:0x04d3, B:210:0x04ec, B:212:0x04f6, B:214:0x04fd, B:216:0x0503), top: B:284:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x05be A[Catch: all -> 0x0623, TryCatch #0 {all -> 0x0623, blocks: (B:258:0x0596, B:260:0x059a, B:264:0x05ab, B:266:0x05ba, B:268:0x05be, B:270:0x05c5, B:269:0x05c1, B:261:0x05a0, B:195:0x0495, B:197:0x0499, B:180:0x0444, B:188:0x046f, B:190:0x0473, B:192:0x0489, B:206:0x04d3, B:210:0x04ec, B:212:0x04f6, B:214:0x04fd, B:216:0x0503), top: B:284:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x05c1 A[Catch: all -> 0x0623, TryCatch #0 {all -> 0x0623, blocks: (B:258:0x0596, B:260:0x059a, B:264:0x05ab, B:266:0x05ba, B:268:0x05be, B:270:0x05c5, B:269:0x05c1, B:261:0x05a0, B:195:0x0495, B:197:0x0499, B:180:0x0444, B:188:0x046f, B:190:0x0473, B:192:0x0489, B:206:0x04d3, B:210:0x04ec, B:212:0x04f6, B:214:0x04fd, B:216:0x0503), top: B:284:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0338 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0499 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult e(String str, boolean z, boolean z2, int i2, int i3) {
        InterceptResult invokeCommon;
        Throwable th;
        RandomAccessFile randomAccessFile;
        StringBuilder sb;
        char c2;
        Exception exc;
        ImageUploadResult imageUploadResult;
        RandomAccessFile randomAccessFile2;
        String str2;
        File file;
        long length;
        ImageUploadResult imageUploadResult2;
        StringBuilder sb2;
        int i4;
        long j2;
        int i5;
        StringBuilder sb3;
        String str3;
        int i6;
        long j3;
        RandomAccessFile randomAccessFile3;
        String a;
        String postMultiNetData;
        ImageUploadResult parser;
        ImageUploadResult imageUploadResult3;
        long j4;
        int i7;
        ImageUploadResult imageUploadResult4;
        long j5;
        int i8;
        long j6;
        String str4;
        StringBuilder sb4;
        BitmapFactory.Options options;
        long j7;
        byte[] bArr;
        int i9;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)})) != null) {
            return (ImageUploadResult) invokeCommon.objValue;
        }
        String str5 = str;
        c.a.r0.y3.t0.c.a("发帖：正在上传图片 = " + str5);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        boolean z3 = true;
        options2.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str5, options2);
        byte[] bArr2 = null;
        if (options2.outWidth != 0 && options2.outHeight != 0) {
            StringBuilder sb5 = new StringBuilder();
            try {
                try {
                    try {
                        file = new File(str5);
                        length = file.length();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    sb = sb5;
                    c2 = 0;
                }
                try {
                    try {
                    } catch (Exception e3) {
                        exc = e3;
                        imageUploadResult = null;
                        randomAccessFile2 = null;
                    }
                    if ((!z && length > 5242880) || (z && length > 10485760)) {
                        imageUploadResult = new ImageUploadResult();
                        try {
                            imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                            imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                            c.a.r0.y3.t0.c.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str5);
                            c.a.d.f.m.a.b(null);
                            this.w = null;
                            return imageUploadResult;
                        } catch (Exception e4) {
                            exc = e4;
                            randomAccessFile2 = null;
                            c2 = 0;
                            sb = sb5;
                            if (!this.o) {
                            }
                            if (imageUploadResult == null) {
                            }
                            if (imageUploadResult != null) {
                            }
                            if (imageUploadResult == null) {
                            }
                            Object[] objArr = new Object[2];
                            objArr[c2] = "comment";
                            objArr[1] = sb.toString();
                            c.a.q0.r.d0.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr);
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("发帖：正在上传图片 上传失败 = ");
                            sb6.append(r4);
                            sb6.append(" ");
                            sb6.append(r3);
                            sb6.append("    p = ");
                            str2 = str;
                            sb6.append(str2);
                            c.a.r0.y3.t0.c.a(sb6.toString());
                            c.a.d.f.m.a.b(randomAccessFile2);
                            this.w = null;
                            c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                            return imageUploadResult;
                        }
                    }
                    c.a.r0.y3.t0.c.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str5);
                    String b2 = t.b(FileHelper.GetStreamFromFile(file));
                    sb5.append("path=");
                    sb5.append(str5);
                    sb5.append("|length=");
                    sb5.append(length);
                    sb5.append("|md5=");
                    sb5.append(b2);
                    if (length != 0 && b2 != null) {
                        String str6 = b2 + this.f12149j;
                        long j8 = length % ((long) this.f12149j) == 0 ? length / this.f12149j : (length / this.f12149j) + 1;
                        sb5.append("|chunkNo=");
                        sb5.append(j8);
                        randomAccessFile = new RandomAccessFile(str5, "r");
                        try {
                            try {
                                sb5.append("|width=");
                                sb5.append(this.k);
                                sb5.append("|height=");
                                sb5.append(this.l);
                                sb5.append("|smallWidth=");
                                sb5.append(this.m);
                                sb5.append("|smallHeight=");
                                sb5.append(this.n);
                                sb5.append("|groupId=");
                                sb5.append(this.q);
                                sb2 = sb5;
                                imageUploadResult2 = null;
                                i4 = 1;
                                j2 = 0;
                                i5 = 0;
                            } catch (Exception e5) {
                                randomAccessFile2 = randomAccessFile;
                                sb = sb5;
                                c2 = 0;
                                exc = e5;
                                imageUploadResult = null;
                            }
                            while (true) {
                                int i10 = (i4 > j8 ? 1 : (i4 == j8 ? 0 : -1));
                                if (i10 > 0) {
                                    break;
                                }
                                try {
                                    if (this.o == z3) {
                                        break;
                                    }
                                    StringBuilder sb7 = sb2;
                                    if (i10 > 0) {
                                        j3 = j8;
                                        sb3 = sb7;
                                        str3 = "|startChunk=";
                                        i6 = 0;
                                        bArr2 = null;
                                    } else {
                                        if (i10 < 0) {
                                            try {
                                                try {
                                                    sb3 = sb7;
                                                    str3 = "|startChunk=";
                                                    i6 = this.f12149j;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    th = th;
                                                    c.a.d.f.m.a.b(randomAccessFile);
                                                    this.w = null;
                                                    throw th;
                                                }
                                            } catch (Exception e6) {
                                                e = e6;
                                                randomAccessFile2 = randomAccessFile;
                                                imageUploadResult = imageUploadResult2;
                                                sb = sb7;
                                                c2 = 0;
                                                exc = e;
                                                if (!this.o) {
                                                }
                                                if (imageUploadResult == null) {
                                                }
                                                if (imageUploadResult != null) {
                                                }
                                                if (imageUploadResult == null) {
                                                }
                                                Object[] objArr2 = new Object[2];
                                                objArr2[c2] = "comment";
                                                objArr2[1] = sb.toString();
                                                c.a.q0.r.d0.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr2);
                                                StringBuilder sb62 = new StringBuilder();
                                                sb62.append("发帖：正在上传图片 上传失败 = ");
                                                sb62.append(r4);
                                                sb62.append(" ");
                                                sb62.append(r3);
                                                sb62.append("    p = ");
                                                str2 = str;
                                                sb62.append(str2);
                                                c.a.r0.y3.t0.c.a(sb62.toString());
                                                c.a.d.f.m.a.b(randomAccessFile2);
                                                this.w = null;
                                                c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                                                return imageUploadResult;
                                            }
                                        } else if (i10 == 0) {
                                            sb3 = sb7;
                                            str3 = "|startChunk=";
                                            i6 = (int) (length - (this.f12149j * (j8 - 1)));
                                        } else {
                                            sb3 = sb7;
                                            str3 = "|startChunk=";
                                            i6 = 0;
                                        }
                                        if (bArr2 != null) {
                                            try {
                                            } catch (Exception e7) {
                                                e = e7;
                                                randomAccessFile2 = randomAccessFile;
                                                imageUploadResult = imageUploadResult2;
                                                sb = sb3;
                                                c2 = 0;
                                                exc = e;
                                                if (!this.o) {
                                                }
                                                if (imageUploadResult == null) {
                                                }
                                                if (imageUploadResult != null) {
                                                }
                                                if (imageUploadResult == null) {
                                                }
                                                Object[] objArr22 = new Object[2];
                                                objArr22[c2] = "comment";
                                                objArr22[1] = sb.toString();
                                                c.a.q0.r.d0.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr22);
                                                StringBuilder sb622 = new StringBuilder();
                                                sb622.append("发帖：正在上传图片 上传失败 = ");
                                                sb622.append(r4);
                                                sb622.append(" ");
                                                sb622.append(r3);
                                                sb622.append("    p = ");
                                                str2 = str;
                                                sb622.append(str2);
                                                c.a.r0.y3.t0.c.a(sb622.toString());
                                                c.a.d.f.m.a.b(randomAccessFile2);
                                                this.w = null;
                                                c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                                                return imageUploadResult;
                                            }
                                        }
                                        try {
                                            bArr2 = new byte[i6];
                                            j3 = j8;
                                            randomAccessFile.seek(this.f12149j * (i4 - 1));
                                            randomAccessFile.read(bArr2, 0, i6);
                                        } catch (Exception e8) {
                                            e = e8;
                                            randomAccessFile2 = randomAccessFile;
                                            sb = sb3;
                                            c2 = 0;
                                            imageUploadResult = imageUploadResult2;
                                            exc = e;
                                            if (!this.o) {
                                            }
                                            if (imageUploadResult == null) {
                                            }
                                            if (imageUploadResult != null) {
                                            }
                                            if (imageUploadResult == null) {
                                            }
                                            Object[] objArr222 = new Object[2];
                                            objArr222[c2] = "comment";
                                            objArr222[1] = sb.toString();
                                            c.a.q0.r.d0.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr222);
                                            StringBuilder sb6222 = new StringBuilder();
                                            sb6222.append("发帖：正在上传图片 上传失败 = ");
                                            sb6222.append(r4);
                                            sb6222.append(" ");
                                            sb6222.append(r3);
                                            sb6222.append("    p = ");
                                            str2 = str;
                                            sb6222.append(str2);
                                            c.a.r0.y3.t0.c.a(sb6222.toString());
                                            c.a.d.f.m.a.b(randomAccessFile2);
                                            this.w = null;
                                            c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                                            return imageUploadResult;
                                        }
                                    }
                                    NetWork netWork = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                    this.w = netWork;
                                    String str7 = str6;
                                    netWork.addPostData("resourceId", str7);
                                    this.w.addPostData("chunkNo", String.valueOf(i4));
                                    if (i10 >= 0) {
                                        try {
                                            randomAccessFile3 = randomAccessFile;
                                            try {
                                                try {
                                                    this.w.addPostData("isFinish", String.valueOf(1));
                                                } catch (Exception e9) {
                                                    e = e9;
                                                    imageUploadResult = imageUploadResult2;
                                                    randomAccessFile2 = randomAccessFile3;
                                                    sb = sb3;
                                                    c2 = 0;
                                                    exc = e;
                                                    if (!this.o) {
                                                    }
                                                    if (imageUploadResult == null) {
                                                    }
                                                    if (imageUploadResult != null) {
                                                    }
                                                    if (imageUploadResult == null) {
                                                    }
                                                    Object[] objArr2222 = new Object[2];
                                                    objArr2222[c2] = "comment";
                                                    objArr2222[1] = sb.toString();
                                                    c.a.q0.r.d0.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr2222);
                                                    StringBuilder sb62222 = new StringBuilder();
                                                    sb62222.append("发帖：正在上传图片 上传失败 = ");
                                                    sb62222.append(r4);
                                                    sb62222.append(" ");
                                                    sb62222.append(r3);
                                                    sb62222.append("    p = ");
                                                    str2 = str;
                                                    sb62222.append(str2);
                                                    c.a.r0.y3.t0.c.a(sb62222.toString());
                                                    c.a.d.f.m.a.b(randomAccessFile2);
                                                    this.w = null;
                                                    c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                                                    return imageUploadResult;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                randomAccessFile = randomAccessFile3;
                                                c.a.d.f.m.a.b(randomAccessFile);
                                                this.w = null;
                                                throw th;
                                            }
                                        } catch (Exception e10) {
                                            e = e10;
                                            randomAccessFile3 = randomAccessFile;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            th = th;
                                            c.a.d.f.m.a.b(randomAccessFile);
                                            this.w = null;
                                            throw th;
                                        }
                                    } else {
                                        randomAccessFile3 = randomAccessFile;
                                        this.w.addPostData("isFinish", String.valueOf(0));
                                    }
                                    if (this.u) {
                                        this.w.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(1));
                                    } else {
                                        this.w.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(0));
                                    }
                                    this.w.addPostData("size", String.valueOf(length));
                                    this.w.addPostData("width", String.valueOf(options2.outWidth));
                                    this.w.addPostData("height", String.valueOf(options2.outHeight));
                                    if (this.m > 0 && this.n > 0) {
                                        this.w.addPostData("smallWidth", String.valueOf(this.m));
                                        this.w.addPostData("smallHeight", String.valueOf(this.n));
                                    }
                                    try {
                                        try {
                                            this.w.addPostData(TbEnum.SystemMessage.KEY_GROUP_ID, String.valueOf(this.q));
                                            this.w.addPostData("alt", "json");
                                            if (bArr2 != null) {
                                                this.w.addPostData("chunk", bArr2);
                                            }
                                            if (z) {
                                                this.w.addPostData("saveOrigin", "1");
                                            } else {
                                                this.w.addPostData("saveOrigin", "0");
                                            }
                                            if (this.p != 0) {
                                                this.w.addPostData("pic_water_type", String.valueOf(this.p));
                                            }
                                            if (z2) {
                                                int b3 = l.c().b();
                                                if (b3 != 0) {
                                                    this.w.addPostData("pic_water_type", String.valueOf(b3));
                                                }
                                                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                if (!StringUtils.isNull(currentAccountName) && b3 == 1) {
                                                    this.w.addPostData("user_name", currentAccountName);
                                                }
                                                String a2 = l.c().a();
                                                if (!StringUtils.isNull(a2)) {
                                                    if (b3 == 2) {
                                                        this.w.addPostData("forum_name", a2);
                                                    }
                                                    a = l.c().a();
                                                    if (!StringUtils.isNull(a)) {
                                                        this.w.addPostData("small_flow_fname", a);
                                                    }
                                                    postMultiNetData = this.w.postMultiNetData(true);
                                                    parser = ImageUploadResult.parser(postMultiNetData);
                                                    if (postMultiNetData != null || parser == null) {
                                                        break;
                                                        break;
                                                    }
                                                    try {
                                                        if (parser.error_code != 0) {
                                                            try {
                                                                if (!ImageUploadResult.shouldReply(parser.error_code)) {
                                                                    break;
                                                                }
                                                            } catch (Exception e11) {
                                                                exc = e11;
                                                                imageUploadResult = parser;
                                                                randomAccessFile2 = randomAccessFile3;
                                                                sb = sb3;
                                                                c2 = 0;
                                                                if (!this.o) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                if (imageUploadResult != null) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                Object[] objArr22222 = new Object[2];
                                                                objArr22222[c2] = "comment";
                                                                objArr22222[1] = sb.toString();
                                                                c.a.q0.r.d0.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr22222);
                                                                StringBuilder sb622222 = new StringBuilder();
                                                                sb622222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb622222.append(r4);
                                                                sb622222.append(" ");
                                                                sb622222.append(r3);
                                                                sb622222.append("    p = ");
                                                                str2 = str;
                                                                sb622222.append(str2);
                                                                c.a.r0.y3.t0.c.a(sb622222.toString());
                                                                c.a.d.f.m.a.b(randomAccessFile2);
                                                                this.w = null;
                                                                c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                                                                return imageUploadResult;
                                                            }
                                                        }
                                                        if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                            c.a.r0.y3.t0.c.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + parser.error_code + "    p = " + str5);
                                                            if (i4 == parser.chunkNo || parser.chunkNo <= 0) {
                                                                break;
                                                            }
                                                            i4 = parser.chunkNo;
                                                            j6 = length;
                                                            imageUploadResult3 = parser;
                                                            str4 = str7;
                                                            i9 = i5 + 1;
                                                            c2 = 0;
                                                            long j9 = j3;
                                                            options = options2;
                                                            randomAccessFile2 = randomAccessFile3;
                                                            j7 = j9;
                                                            StringBuilder sb8 = sb3;
                                                            bArr = bArr2;
                                                            sb = sb8;
                                                            try {
                                                                if (i9 <= this.v) {
                                                                    sb.append("|possbile dead loop found. tryCount=");
                                                                    sb.append(i9);
                                                                    sb.append(", chunkNo=");
                                                                    sb.append(j7);
                                                                    break;
                                                                }
                                                                i5 = i9;
                                                                imageUploadResult2 = imageUploadResult3;
                                                                j8 = j7;
                                                                sb2 = sb;
                                                                str6 = str4;
                                                                bArr2 = bArr;
                                                                options2 = options;
                                                                randomAccessFile = randomAccessFile2;
                                                                length = j6;
                                                                z3 = true;
                                                                str5 = str;
                                                            } catch (Exception e12) {
                                                                e = e12;
                                                                exc = e;
                                                                imageUploadResult = imageUploadResult3;
                                                                if (!this.o) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                if (imageUploadResult != null) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                Object[] objArr222222 = new Object[2];
                                                                objArr222222[c2] = "comment";
                                                                objArr222222[1] = sb.toString();
                                                                c.a.q0.r.d0.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr222222);
                                                                StringBuilder sb6222222 = new StringBuilder();
                                                                sb6222222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb6222222.append(r4);
                                                                sb6222222.append(" ");
                                                                sb6222222.append(r3);
                                                                sb6222222.append("    p = ");
                                                                str2 = str;
                                                                sb6222222.append(str2);
                                                                c.a.r0.y3.t0.c.a(sb6222222.toString());
                                                                c.a.d.f.m.a.b(randomAccessFile2);
                                                                this.w = null;
                                                                c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                                                                return imageUploadResult;
                                                            }
                                                        } else {
                                                            StringBuilder sb9 = sb3;
                                                            try {
                                                                if (ImageUploadResult.shouldReply(parser.error_code)) {
                                                                    j6 = length;
                                                                    imageUploadResult3 = parser;
                                                                    str4 = str7;
                                                                    bArr = bArr2;
                                                                    i9 = i5 + 1;
                                                                    c2 = 0;
                                                                    sb = sb9;
                                                                    long j10 = j3;
                                                                    options = options2;
                                                                    randomAccessFile2 = randomAccessFile3;
                                                                    j7 = j10;
                                                                } else {
                                                                    int i11 = i4 + 1;
                                                                    j2 += i6;
                                                                    if (i11 > 1) {
                                                                        try {
                                                                            j4 = j2 + ((i11 - 1) * this.f12149j);
                                                                        } catch (Exception e13) {
                                                                            exc = e13;
                                                                            imageUploadResult = parser;
                                                                            sb = sb9;
                                                                            randomAccessFile2 = randomAccessFile3;
                                                                            c2 = 0;
                                                                            if (!this.o) {
                                                                                sb.append("|request cancelled.");
                                                                            } else {
                                                                                BdLog.e(exc.getMessage());
                                                                            }
                                                                            if (imageUploadResult == null) {
                                                                                imageUploadResult = new ImageUploadResult();
                                                                                imageUploadResult.error_code = -1002;
                                                                                imageUploadResult.error_msg = exc.getMessage();
                                                                            }
                                                                            int i12 = imageUploadResult != null ? imageUploadResult.error_code : -1002;
                                                                            String message = imageUploadResult == null ? imageUploadResult.error_msg : exc.getMessage();
                                                                            Object[] objArr2222222 = new Object[2];
                                                                            objArr2222222[c2] = "comment";
                                                                            objArr2222222[1] = sb.toString();
                                                                            c.a.q0.r.d0.a.a("img", -1L, -1, "imageUpload", i12, message, objArr2222222);
                                                                            StringBuilder sb62222222 = new StringBuilder();
                                                                            sb62222222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb62222222.append(i12);
                                                                            sb62222222.append(" ");
                                                                            sb62222222.append(message);
                                                                            sb62222222.append("    p = ");
                                                                            str2 = str;
                                                                            sb62222222.append(str2);
                                                                            c.a.r0.y3.t0.c.a(sb62222222.toString());
                                                                            c.a.d.f.m.a.b(randomAccessFile2);
                                                                            this.w = null;
                                                                            c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                                                                            return imageUploadResult;
                                                                        }
                                                                    } else {
                                                                        j4 = j2;
                                                                    }
                                                                    if (this.f12146g != null) {
                                                                        i7 = i11;
                                                                        this.f12146g.hasUploadFileSize += i6;
                                                                    } else {
                                                                        i7 = i11;
                                                                    }
                                                                    c.a.r0.y3.t0.c.a("发帖：正在上传图片 已上传 = " + j4 + "    p = " + str5);
                                                                    if (this.r != null) {
                                                                        try {
                                                                            j5 = j4;
                                                                            RandomAccessFile randomAccessFile4 = randomAccessFile3;
                                                                            i8 = i7;
                                                                            j6 = length;
                                                                            imageUploadResult4 = parser;
                                                                            str4 = str7;
                                                                            c2 = 0;
                                                                            sb4 = sb9;
                                                                            long j11 = j3;
                                                                            options = options2;
                                                                            randomAccessFile2 = randomAccessFile4;
                                                                            j7 = j11;
                                                                        } catch (Exception e14) {
                                                                            imageUploadResult4 = parser;
                                                                            randomAccessFile2 = randomAccessFile3;
                                                                            c2 = 0;
                                                                            exc = e14;
                                                                            sb = sb9;
                                                                        }
                                                                        try {
                                                                            this.r.a(str, this.t, j5, j6);
                                                                        } catch (Exception e15) {
                                                                            exc = e15;
                                                                            sb = sb4;
                                                                            imageUploadResult = imageUploadResult4;
                                                                            if (!this.o) {
                                                                            }
                                                                            if (imageUploadResult == null) {
                                                                            }
                                                                            if (imageUploadResult != null) {
                                                                            }
                                                                            if (imageUploadResult == null) {
                                                                            }
                                                                            Object[] objArr22222222 = new Object[2];
                                                                            objArr22222222[c2] = "comment";
                                                                            objArr22222222[1] = sb.toString();
                                                                            c.a.q0.r.d0.a.a("img", -1L, -1, "imageUpload", i12, message, objArr22222222);
                                                                            StringBuilder sb622222222 = new StringBuilder();
                                                                            sb622222222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb622222222.append(i12);
                                                                            sb622222222.append(" ");
                                                                            sb622222222.append(message);
                                                                            sb622222222.append("    p = ");
                                                                            str2 = str;
                                                                            sb622222222.append(str2);
                                                                            c.a.r0.y3.t0.c.a(sb622222222.toString());
                                                                            c.a.d.f.m.a.b(randomAccessFile2);
                                                                            this.w = null;
                                                                            c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                                                                            return imageUploadResult;
                                                                        }
                                                                    } else {
                                                                        j5 = j4;
                                                                        j6 = length;
                                                                        imageUploadResult4 = parser;
                                                                        c2 = 0;
                                                                        sb4 = sb9;
                                                                        int i13 = i7;
                                                                        str4 = str7;
                                                                        long j12 = j3;
                                                                        options = options2;
                                                                        randomAccessFile2 = randomAccessFile3;
                                                                        i8 = i13;
                                                                        j7 = j12;
                                                                    }
                                                                    try {
                                                                        if (this.s != null) {
                                                                            long j13 = j5;
                                                                            bArr = bArr2;
                                                                            imageUploadResult3 = imageUploadResult4;
                                                                            sb = sb4;
                                                                            this.s.a(str, this.t, j13, j6, i2, i3);
                                                                        } else {
                                                                            imageUploadResult3 = imageUploadResult4;
                                                                            bArr = bArr2;
                                                                            sb = sb4;
                                                                        }
                                                                        i4 = i8;
                                                                        i9 = i5;
                                                                    } catch (Exception e16) {
                                                                        e = e16;
                                                                        sb = sb4;
                                                                        imageUploadResult3 = imageUploadResult4;
                                                                        exc = e;
                                                                        imageUploadResult = imageUploadResult3;
                                                                        if (!this.o) {
                                                                        }
                                                                        if (imageUploadResult == null) {
                                                                        }
                                                                        if (imageUploadResult != null) {
                                                                        }
                                                                        if (imageUploadResult == null) {
                                                                        }
                                                                        Object[] objArr222222222 = new Object[2];
                                                                        objArr222222222[c2] = "comment";
                                                                        objArr222222222[1] = sb.toString();
                                                                        c.a.q0.r.d0.a.a("img", -1L, -1, "imageUpload", i12, message, objArr222222222);
                                                                        StringBuilder sb6222222222 = new StringBuilder();
                                                                        sb6222222222.append("发帖：正在上传图片 上传失败 = ");
                                                                        sb6222222222.append(i12);
                                                                        sb6222222222.append(" ");
                                                                        sb6222222222.append(message);
                                                                        sb6222222222.append("    p = ");
                                                                        str2 = str;
                                                                        sb6222222222.append(str2);
                                                                        c.a.r0.y3.t0.c.a(sb6222222222.toString());
                                                                        c.a.d.f.m.a.b(randomAccessFile2);
                                                                        this.w = null;
                                                                        c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                                                                        return imageUploadResult;
                                                                    }
                                                                }
                                                                if (i9 <= this.v) {
                                                                }
                                                            } catch (Exception e17) {
                                                                e = e17;
                                                                imageUploadResult3 = parser;
                                                                sb = sb9;
                                                                randomAccessFile2 = randomAccessFile3;
                                                                c2 = 0;
                                                                exc = e;
                                                                imageUploadResult = imageUploadResult3;
                                                                if (!this.o) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                if (imageUploadResult != null) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                Object[] objArr2222222222 = new Object[2];
                                                                objArr2222222222[c2] = "comment";
                                                                objArr2222222222[1] = sb.toString();
                                                                c.a.q0.r.d0.a.a("img", -1L, -1, "imageUpload", i12, message, objArr2222222222);
                                                                StringBuilder sb62222222222 = new StringBuilder();
                                                                sb62222222222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb62222222222.append(i12);
                                                                sb62222222222.append(" ");
                                                                sb62222222222.append(message);
                                                                sb62222222222.append("    p = ");
                                                                str2 = str;
                                                                sb62222222222.append(str2);
                                                                c.a.r0.y3.t0.c.a(sb62222222222.toString());
                                                                c.a.d.f.m.a.b(randomAccessFile2);
                                                                this.w = null;
                                                                c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                                                                return imageUploadResult;
                                                            }
                                                        }
                                                    } catch (Exception e18) {
                                                        e = e18;
                                                        imageUploadResult3 = parser;
                                                        randomAccessFile2 = randomAccessFile3;
                                                        sb = sb3;
                                                    }
                                                }
                                            }
                                            a = l.c().a();
                                            if (!StringUtils.isNull(a)) {
                                            }
                                            postMultiNetData = this.w.postMultiNetData(true);
                                            parser = ImageUploadResult.parser(postMultiNetData);
                                            if (postMultiNetData != null) {
                                                break;
                                            }
                                            if (parser.error_code != 0) {
                                            }
                                            if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                            }
                                        } catch (Exception e19) {
                                            e = e19;
                                            randomAccessFile2 = randomAccessFile3;
                                            sb = sb3;
                                            c2 = 0;
                                            imageUploadResult = imageUploadResult2;
                                            exc = e;
                                            if (!this.o) {
                                            }
                                            if (imageUploadResult == null) {
                                            }
                                            if (imageUploadResult != null) {
                                            }
                                            if (imageUploadResult == null) {
                                            }
                                            Object[] objArr22222222222 = new Object[2];
                                            objArr22222222222[c2] = "comment";
                                            objArr22222222222[1] = sb.toString();
                                            c.a.q0.r.d0.a.a("img", -1L, -1, "imageUpload", i12, message, objArr22222222222);
                                            StringBuilder sb622222222222 = new StringBuilder();
                                            sb622222222222.append("发帖：正在上传图片 上传失败 = ");
                                            sb622222222222.append(i12);
                                            sb622222222222.append(" ");
                                            sb622222222222.append(message);
                                            sb622222222222.append("    p = ");
                                            str2 = str;
                                            sb622222222222.append(str2);
                                            c.a.r0.y3.t0.c.a(sb622222222222.toString());
                                            c.a.d.f.m.a.b(randomAccessFile2);
                                            this.w = null;
                                            c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                                            return imageUploadResult;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        RandomAccessFile randomAccessFile5 = randomAccessFile3;
                                        th = th;
                                        randomAccessFile = randomAccessFile5;
                                        c.a.d.f.m.a.b(randomAccessFile);
                                        this.w = null;
                                        throw th;
                                    }
                                } catch (Exception e20) {
                                    e = e20;
                                    randomAccessFile2 = randomAccessFile;
                                    sb = sb2;
                                }
                                c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                                return imageUploadResult;
                            }
                            imageUploadResult2 = imageUploadResult3;
                            randomAccessFile = randomAccessFile2;
                            c.a.d.f.m.a.b(randomAccessFile);
                            this.w = null;
                            imageUploadResult = imageUploadResult2;
                            str2 = str;
                            c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                            return imageUploadResult;
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    }
                    sb = sb5;
                    c2 = 0;
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = -1007;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_not_exist);
                    TiebaStatic.imgError(-1007, "file error: " + imageUploadResult.error_msg, sb.toString());
                    imageUploadResult2 = imageUploadResult;
                    randomAccessFile = null;
                    c.a.d.f.m.a.b(randomAccessFile);
                    this.w = null;
                    imageUploadResult = imageUploadResult2;
                    str2 = str;
                    c.a.r0.y3.t0.c.a("发帖：上传图片 结束      p = " + str2);
                    return imageUploadResult;
                } catch (Throwable th8) {
                    th = th8;
                    randomAccessFile = null;
                }
            } catch (Throwable th9) {
                th = th9;
                randomAccessFile = null;
            }
        } else {
            c.a.r0.y3.t0.c.a("发帖：正在上传图片 失败 = " + str5);
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ErrorData errorData = new ErrorData();
            ImageFileInfo imageFileInfo = this.f12145f.get(this.f12148i);
            if (TextUtils.isEmpty(imageFileInfo.getTempUploadFileName())) {
                imageFileInfo.setTempUploadFileName("img_upload_temp_file_" + this.f12148i + ".temp");
            }
            c.a.r0.y3.t0.c.a("发帖：发送图片 上传图片 = " + this.f12148i + " = " + imageFileInfo.toJson().toString());
            boolean isOriginalImg = imageFileInfo.getImageType() == 1 ? false : this.f12146g.isOriginalImg();
            c.a.r0.y3.t0.a.m(this.y, imageFileInfo);
            ImageUploadResult d2 = d(imageFileInfo, isOriginalImg, this.f12147h, this.f12148i + 1, this.f12145f.size());
            c.a.r0.y3.t0.a.d(this.y, imageFileInfo, d2);
            if (d2 != null) {
                UploadedImageInfo uploadedPicInfo = d2.getUploadedPicInfo();
                if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                    uploadedPicInfo.isGif = imageFileInfo.isGif();
                    uploadedPicInfo.isBJH = this.u;
                    imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                    return Boolean.TRUE;
                }
                errorData.setError_code(d2.error_code);
                errorData.setError_msg(d2.error_msg);
                c.a.r0.y3.t0.c.a("发帖：发送图片 上传图片 错误 1= " + this.f12148i + " = " + imageFileInfo.toJson().toString());
                this.f12144e.a(errorData);
                return Boolean.FALSE;
            }
            errorData.setError_code(-52);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
            c.a.r0.y3.t0.c.a("发帖：发送图片 上传图片 错误 2= " + this.f12148i + " = " + imageFileInfo.toJson().toString());
            this.f12144e.a(errorData);
            return Boolean.FALSE;
        }
        return (Boolean) invokeV.objValue;
    }
}
