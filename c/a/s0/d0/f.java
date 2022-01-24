package c.a.s0.d0;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.t;
import c.a.s0.s.k;
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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f12463b;

    /* renamed from: c  reason: collision with root package name */
    public int f12464c;

    /* renamed from: d  reason: collision with root package name */
    public int f12465d;

    /* renamed from: e  reason: collision with root package name */
    public int f12466e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12467f;

    /* renamed from: g  reason: collision with root package name */
    public String f12468g;

    /* renamed from: h  reason: collision with root package name */
    public NetWork f12469h;

    /* renamed from: i  reason: collision with root package name */
    public a f12470i;

    /* renamed from: j  reason: collision with root package name */
    public b f12471j;
    public Object k;
    public e l;
    public boolean m;
    public WriteData n;
    public WriteImagesInfo o;
    public int p;
    public int q;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, Object obj, long j2, long j3);
    }

    /* loaded from: classes6.dex */
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
        this.a = 512000;
        this.f12468g = "1";
        this.f12469h = null;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12467f = true;
            NetWork netWork = this.f12469h;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.a = i2;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f12468g = str;
        }
    }

    public void d(a aVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, obj) == null) {
            this.f12470i = aVar;
            this.k = obj;
            if (aVar != null) {
                this.a = 10240;
            }
        }
    }

    public void e(b bVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bVar, obj) == null) {
            this.f12471j = bVar;
            this.k = obj;
        }
    }

    public void f(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            this.f12463b = i2;
            this.f12464c = i3;
            this.f12465d = i4;
            this.f12466e = i5;
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.q = i2;
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

    /* JADX DEBUG: Multi-variable search result rejected for r12v10, resolved type: com.baidu.tbadk.core.util.NetWork */
    /* JADX DEBUG: Multi-variable search result rejected for r12v13, resolved type: com.baidu.tbadk.core.util.NetWork */
    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: com.baidu.tbadk.img.ImageUploadResult */
    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: com.baidu.tbadk.img.ImageUploadResult */
    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: com.baidu.tbadk.img.ImageUploadResult */
    /* JADX WARN: Can't wrap try/catch for region: R(11:44|(15:48|49|(1:51)(1:311)|52|54|55|56|57|58|(2:59|(4:61|62|63|(1:283)(23:(1:66)(5:(2:276|277)(1:(2:261|262)(1:275))|(3:264|265|266)|273|274|268)|67|68|(5:242|243|244|245|246)(2:70|71)|72|73|(2:75|76)(1:240)|77|(1:81)|82|83|(1:85)|86|(1:88)(1:233)|89|90|(1:92)|(6:94|(1:96)|97|(1:101)|102|(6:104|(1:106)|107|(1:109)|110|(9:113|114|(3:204|205|(1:207))|116|(2:118|(2:122|123)(1:154))(4:155|156|157|(1:159)(13:160|(3:162|163|164)(1:199)|165|(1:167)|168|(5:184|185|186|187|188)(1:170)|171|172|(3:174|175|176)(1:178)|177|125|126|(2:129|130)(1:128)))|124|125|126|(0)(0))(2:231|230)))|232|107|(0)|110|(1:231)(9:113|114|(0)|116|(0)(0)|124|125|126|(0)(0))))(2:296|297))|131|132|133|36|37)|312|313|314|315|316|317|133|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03a5, code lost:
        r3 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x03a7, code lost:
        r3.append("|startChunk=");
        r3.append(r7);
        c.a.t0.x3.s0.c.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03c2, code lost:
        r15 = r4;
        r29 = r25;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03c8, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03c9, code lost:
        r2 = r0;
        r11 = r3;
        r7 = r4;
        r29 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x050b, code lost:
        r15 = r4;
        r29 = r25;
        r11 = r27;
        r24 = 0;
        r25 = r12;
        r12 = null;
        r11.append("|startChunk=");
        r11.append(r7);
        r11.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0521, code lost:
        if (r15 != null) goto L222;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0523, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0525, code lost:
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0526, code lost:
        r11.append(r9);
        r11.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x052f, code lost:
        if (r15 == null) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0531, code lost:
        r11.append(r15.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0536, code lost:
        if (r15 != null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0538, code lost:
        r7 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x053e, code lost:
        r7.error_code = -7;
        r7.error_msg = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0542, code lost:
        r23 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0545, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x05dc, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x05dd, code lost:
        r2 = r0;
        r29 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x05e6, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x017c, code lost:
        r15.append("|startChunk=");
        r15.append(r7);
        r3 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0189, code lost:
        r3.error_code = -54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x018b, code lost:
        r7 = r2;
        r23 = r3;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0191, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0192, code lost:
        r29 = r2;
        r7 = r3;
        r25 = r12;
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01d2, code lost:
        if (r14.length != r9) goto L273;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:138:0x033e A[Catch: all -> 0x021b, Exception -> 0x021d, TRY_ENTER, TRY_LEAVE, TryCatch #9 {Exception -> 0x021d, blocks: (B:80:0x0213, B:100:0x024b, B:105:0x028b, B:107:0x028f, B:110:0x02c1, B:113:0x02cc, B:119:0x02e1, B:121:0x02ee, B:123:0x02f8, B:124:0x0301, B:128:0x030e, B:129:0x0316, B:133:0x0327, B:138:0x033e), top: B:301:0x0213 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x036d A[Catch: all -> 0x021b, Exception -> 0x0362, TRY_ENTER, TryCatch #17 {Exception -> 0x0362, blocks: (B:144:0x0358, B:151:0x036d, B:153:0x038e, B:156:0x0393, B:171:0x0403, B:176:0x0411), top: B:309:0x0358 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04d7 A[LOOP:0: B:42:0x0170->B:202:0x04d7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x05fd A[Catch: all -> 0x068e, TryCatch #22 {all -> 0x068e, blocks: (B:267:0x05f9, B:269:0x05fd, B:273:0x060f, B:276:0x0620, B:278:0x0624, B:280:0x062b, B:279:0x0627, B:270:0x0604, B:199:0x04c0, B:201:0x04c4, B:196:0x04b1, B:212:0x050b, B:216:0x0526, B:218:0x0531, B:220:0x0538, B:222:0x053e), top: B:311:0x04c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0604 A[Catch: all -> 0x068e, TryCatch #22 {all -> 0x068e, blocks: (B:267:0x05f9, B:269:0x05fd, B:273:0x060f, B:276:0x0620, B:278:0x0624, B:280:0x062b, B:279:0x0627, B:270:0x0604, B:199:0x04c0, B:201:0x04c4, B:196:0x04b1, B:212:0x050b, B:216:0x0526, B:218:0x0531, B:220:0x0538, B:222:0x053e), top: B:311:0x04c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x060f A[Catch: all -> 0x068e, TryCatch #22 {all -> 0x068e, blocks: (B:267:0x05f9, B:269:0x05fd, B:273:0x060f, B:276:0x0620, B:278:0x0624, B:280:0x062b, B:279:0x0627, B:270:0x0604, B:199:0x04c0, B:201:0x04c4, B:196:0x04b1, B:212:0x050b, B:216:0x0526, B:218:0x0531, B:220:0x0538, B:222:0x053e), top: B:311:0x04c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0620 A[Catch: all -> 0x068e, TryCatch #22 {all -> 0x068e, blocks: (B:267:0x05f9, B:269:0x05fd, B:273:0x060f, B:276:0x0620, B:278:0x0624, B:280:0x062b, B:279:0x0627, B:270:0x0604, B:199:0x04c0, B:201:0x04c4, B:196:0x04b1, B:212:0x050b, B:216:0x0526, B:218:0x0531, B:220:0x0538, B:222:0x053e), top: B:311:0x04c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0624 A[Catch: all -> 0x068e, TryCatch #22 {all -> 0x068e, blocks: (B:267:0x05f9, B:269:0x05fd, B:273:0x060f, B:276:0x0620, B:278:0x0624, B:280:0x062b, B:279:0x0627, B:270:0x0604, B:199:0x04c0, B:201:0x04c4, B:196:0x04b1, B:212:0x050b, B:216:0x0526, B:218:0x0531, B:220:0x0538, B:222:0x053e), top: B:311:0x04c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0627 A[Catch: all -> 0x068e, TryCatch #22 {all -> 0x068e, blocks: (B:267:0x05f9, B:269:0x05fd, B:273:0x060f, B:276:0x0620, B:278:0x0624, B:280:0x062b, B:279:0x0627, B:270:0x0604, B:199:0x04c0, B:201:0x04c4, B:196:0x04b1, B:212:0x050b, B:216:0x0526, B:218:0x0531, B:220:0x0538, B:222:0x053e), top: B:311:0x04c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0358 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x04c4 A[SYNTHETIC] */
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
        ImageUploadResult imageUploadResult;
        String str3;
        ImageUploadResult imageUploadResult2;
        File file;
        long length;
        RandomAccessFile randomAccessFile2;
        ImageUploadResult imageUploadResult3;
        int i4;
        StringBuilder sb2;
        byte[] bArr;
        long j2;
        RandomAccessFile randomAccessFile3;
        ImageUploadResult imageUploadResult4;
        RandomAccessFile randomAccessFile4;
        String a2;
        String postMultiNetData;
        ImageUploadResult parser;
        ImageUploadResult imageUploadResult5;
        long j3;
        BitmapFactory.Options options;
        byte[] bArr2;
        long j4;
        long j5;
        String str4;
        NetWork netWork2;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            String str5 = str;
            String str6 = "    p = ";
            c.a.t0.x3.s0.c.a("发帖：正在上传图片 = " + str5);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            boolean z3 = true;
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str5, options2);
            if (options2.outWidth != 0 && options2.outHeight != 0) {
                StringBuilder sb3 = new StringBuilder();
                RandomAccessFile randomAccessFile5 = null;
                ImageUploadResult imageUploadResult6 = null;
                RandomAccessFile randomAccessFile6 = null;
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
                    ImageUploadResult imageUploadResult7 = new ImageUploadResult();
                    try {
                        imageUploadResult7.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult7.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                        c.a.t0.x3.s0.c.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str5);
                        c.a.d.f.m.a.b(null);
                        this.f12469h = null;
                        return imageUploadResult7;
                    } catch (Exception e4) {
                        e = e4;
                        randomAccessFile = null;
                        str2 = "    p = ";
                        sb = sb3;
                        c2 = 0;
                        imageUploadResult3 = imageUploadResult7;
                        netWork = null;
                    }
                } else {
                    c.a.t0.x3.s0.c.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str5);
                    String b2 = t.b(FileHelper.GetStreamFromFile(file));
                    sb3.append("path=");
                    sb3.append(str5);
                    sb3.append("|length=");
                    sb3.append(length);
                    sb3.append("|md5=");
                    sb3.append(b2);
                    long j6 = 0;
                    try {
                        if (length != 0 && b2 != null) {
                            String str7 = b2 + this.a;
                            long j7 = length % ((long) this.a) == 0 ? length / this.a : (length / this.a) + 1;
                            sb3.append("|chunkNo=");
                            sb3.append(j7);
                            try {
                                RandomAccessFile randomAccessFile7 = new RandomAccessFile(str5, "r");
                                try {
                                    try {
                                        sb3.append("|width=");
                                        sb3.append(this.f12463b);
                                        sb3.append("|height=");
                                        sb3.append(this.f12464c);
                                        sb3.append("|smallWidth=");
                                        sb3.append(this.f12465d);
                                        sb3.append("|smallHeight=");
                                        sb3.append(this.f12466e);
                                        sb3.append("|groupId=");
                                        sb3.append(this.f12468g);
                                        int i7 = 1;
                                        int i8 = 0;
                                        imageUploadResult = null;
                                        byte[] bArr3 = null;
                                        while (true) {
                                            int i9 = (i7 > j7 ? 1 : (i7 == j7 ? 0 : -1));
                                            if (i9 > 0) {
                                                randomAccessFile = randomAccessFile7;
                                                netWork = null;
                                                break;
                                            }
                                            try {
                                                if (this.f12467f == z3) {
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
                                                                i4 = this.a;
                                                                sb2 = sb3;
                                                            } catch (Exception e5) {
                                                                e = e5;
                                                                randomAccessFile = randomAccessFile7;
                                                                str2 = str6;
                                                                sb = sb3;
                                                                imageUploadResult3 = imageUploadResult;
                                                                netWork = null;
                                                                c2 = 0;
                                                                exc = e;
                                                                imageUploadResult6 = imageUploadResult3;
                                                                if (!this.f12467f) {
                                                                }
                                                                if (imageUploadResult6 != null) {
                                                                }
                                                                if (imageUploadResult2 != null) {
                                                                }
                                                                if (imageUploadResult2 == null) {
                                                                }
                                                                Object[] objArr = new Object[2];
                                                                objArr[c2] = "comment";
                                                                objArr[1] = sb.toString();
                                                                c.a.s0.s.c0.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr);
                                                                StringBuilder sb4 = new StringBuilder();
                                                                sb4.append("发帖：正在上传图片 上传失败 = ");
                                                                sb4.append(r3);
                                                                sb4.append(" ");
                                                                sb4.append(r2);
                                                                sb4.append(str2);
                                                                str3 = str;
                                                                sb4.append(str3);
                                                                c.a.t0.x3.s0.c.a(sb4.toString());
                                                                c.a.d.f.m.a.b(randomAccessFile);
                                                                this.f12469h = netWork;
                                                                imageUploadResult = imageUploadResult2;
                                                                c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                                                                return imageUploadResult;
                                                            }
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            randomAccessFile5 = randomAccessFile7;
                                                            netWork = null;
                                                            th = th;
                                                            randomAccessFile6 = randomAccessFile5;
                                                            c.a.d.f.m.a.b(randomAccessFile6);
                                                            this.f12469h = netWork;
                                                            throw th;
                                                        }
                                                    } else if (i9 == 0) {
                                                        sb2 = sb3;
                                                        i4 = (int) (length - (this.a * (j7 - 1)));
                                                    } else {
                                                        sb2 = sb3;
                                                        i4 = 0;
                                                    }
                                                    if (bArr3 != null) {
                                                        bArr = bArr3;
                                                        try {
                                                        } catch (Exception e6) {
                                                            e = e6;
                                                            randomAccessFile = randomAccessFile7;
                                                            str2 = str6;
                                                            imageUploadResult3 = imageUploadResult;
                                                            sb = sb2;
                                                            netWork = null;
                                                            c2 = 0;
                                                            exc = e;
                                                            imageUploadResult6 = imageUploadResult3;
                                                            if (!this.f12467f) {
                                                            }
                                                            if (imageUploadResult6 != null) {
                                                            }
                                                            if (imageUploadResult2 != null) {
                                                            }
                                                            if (imageUploadResult2 == null) {
                                                            }
                                                            Object[] objArr2 = new Object[2];
                                                            objArr2[c2] = "comment";
                                                            objArr2[1] = sb.toString();
                                                            c.a.s0.s.c0.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr2);
                                                            StringBuilder sb42 = new StringBuilder();
                                                            sb42.append("发帖：正在上传图片 上传失败 = ");
                                                            sb42.append(r3);
                                                            sb42.append(" ");
                                                            sb42.append(r2);
                                                            sb42.append(str2);
                                                            str3 = str;
                                                            sb42.append(str3);
                                                            c.a.t0.x3.s0.c.a(sb42.toString());
                                                            c.a.d.f.m.a.b(randomAccessFile);
                                                            this.f12469h = netWork;
                                                            imageUploadResult = imageUploadResult2;
                                                            c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                                                            return imageUploadResult;
                                                        }
                                                    }
                                                    try {
                                                        bArr = new byte[i4];
                                                        j2 = j7;
                                                        randomAccessFile7.seek(this.a * (i7 - 1));
                                                        randomAccessFile7.read(bArr, 0, i4);
                                                    } catch (Exception e7) {
                                                        e = e7;
                                                        randomAccessFile = randomAccessFile7;
                                                        str2 = str6;
                                                        sb = sb2;
                                                        netWork = null;
                                                        c2 = 0;
                                                        exc = e;
                                                        imageUploadResult6 = imageUploadResult;
                                                        if (!this.f12467f) {
                                                        }
                                                        if (imageUploadResult6 != null) {
                                                        }
                                                        if (imageUploadResult2 != null) {
                                                        }
                                                        if (imageUploadResult2 == null) {
                                                        }
                                                        Object[] objArr22 = new Object[2];
                                                        objArr22[c2] = "comment";
                                                        objArr22[1] = sb.toString();
                                                        c.a.s0.s.c0.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr22);
                                                        StringBuilder sb422 = new StringBuilder();
                                                        sb422.append("发帖：正在上传图片 上传失败 = ");
                                                        sb422.append(r3);
                                                        sb422.append(" ");
                                                        sb422.append(r2);
                                                        sb422.append(str2);
                                                        str3 = str;
                                                        sb422.append(str3);
                                                        c.a.t0.x3.s0.c.a(sb422.toString());
                                                        c.a.d.f.m.a.b(randomAccessFile);
                                                        this.f12469h = netWork;
                                                        imageUploadResult = imageUploadResult2;
                                                        c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                                                        return imageUploadResult;
                                                    }
                                                }
                                                NetWork netWork4 = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                                this.f12469h = netWork4;
                                                netWork4.addPostData("resourceId", str7);
                                                this.f12469h.addPostData("chunkNo", String.valueOf(i7));
                                                if (i9 >= 0) {
                                                    try {
                                                        randomAccessFile3 = randomAccessFile7;
                                                        try {
                                                            try {
                                                                this.f12469h.addPostData("isFinish", String.valueOf(1));
                                                            } catch (Exception e8) {
                                                                e = e8;
                                                                exc = e;
                                                                imageUploadResult4 = imageUploadResult;
                                                                randomAccessFile = randomAccessFile3;
                                                                sb = sb2;
                                                                ImageUploadResult imageUploadResult8 = imageUploadResult4;
                                                                c2 = 0;
                                                                str2 = str6;
                                                                netWork = null;
                                                                imageUploadResult6 = imageUploadResult8;
                                                                if (!this.f12467f) {
                                                                }
                                                                if (imageUploadResult6 != null) {
                                                                }
                                                                if (imageUploadResult2 != null) {
                                                                }
                                                                if (imageUploadResult2 == null) {
                                                                }
                                                                Object[] objArr222 = new Object[2];
                                                                objArr222[c2] = "comment";
                                                                objArr222[1] = sb.toString();
                                                                c.a.s0.s.c0.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr222);
                                                                StringBuilder sb4222 = new StringBuilder();
                                                                sb4222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb4222.append(r3);
                                                                sb4222.append(" ");
                                                                sb4222.append(r2);
                                                                sb4222.append(str2);
                                                                str3 = str;
                                                                sb4222.append(str3);
                                                                c.a.t0.x3.s0.c.a(sb4222.toString());
                                                                c.a.d.f.m.a.b(randomAccessFile);
                                                                this.f12469h = netWork;
                                                                imageUploadResult = imageUploadResult2;
                                                                c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                                                                return imageUploadResult;
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            th = th;
                                                            randomAccessFile4 = randomAccessFile3;
                                                            netWork = null;
                                                            randomAccessFile6 = randomAccessFile4;
                                                            c.a.d.f.m.a.b(randomAccessFile6);
                                                            this.f12469h = netWork;
                                                            throw th;
                                                        }
                                                    } catch (Exception e9) {
                                                        e = e9;
                                                        randomAccessFile3 = randomAccessFile7;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        randomAccessFile3 = randomAccessFile7;
                                                        th = th;
                                                        randomAccessFile4 = randomAccessFile3;
                                                        netWork = null;
                                                        randomAccessFile6 = randomAccessFile4;
                                                        c.a.d.f.m.a.b(randomAccessFile6);
                                                        this.f12469h = netWork;
                                                        throw th;
                                                    }
                                                } else {
                                                    randomAccessFile3 = randomAccessFile7;
                                                    this.f12469h.addPostData("isFinish", String.valueOf(0));
                                                }
                                                if (this.m) {
                                                    this.f12469h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(1));
                                                } else {
                                                    this.f12469h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(0));
                                                }
                                                this.f12469h.addPostData("size", String.valueOf(length));
                                                this.f12469h.addPostData("width", String.valueOf(options2.outWidth));
                                                this.f12469h.addPostData("height", String.valueOf(options2.outHeight));
                                                if (this.f12465d > 0 && this.f12466e > 0) {
                                                    this.f12469h.addPostData("smallWidth", String.valueOf(this.f12465d));
                                                    this.f12469h.addPostData("smallHeight", String.valueOf(this.f12466e));
                                                }
                                                try {
                                                    try {
                                                        this.f12469h.addPostData(TbEnum.SystemMessage.KEY_GROUP_ID, String.valueOf(this.f12468g));
                                                        this.f12469h.addPostData("alt", "json");
                                                        if (bArr != null) {
                                                            this.f12469h.addPostData("chunk", bArr);
                                                        }
                                                        if (z) {
                                                            this.f12469h.addPostData("saveOrigin", "1");
                                                        } else {
                                                            this.f12469h.addPostData("saveOrigin", "0");
                                                        }
                                                        if (this.q != 0) {
                                                            this.f12469h.addPostData("pic_water_type", String.valueOf(this.q));
                                                        }
                                                        if (z2) {
                                                            int b3 = k.c().b();
                                                            if (b3 != 0) {
                                                                this.f12469h.addPostData("pic_water_type", String.valueOf(b3));
                                                            }
                                                            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                            if (!StringUtils.isNull(currentAccountName) && b3 == 1) {
                                                                this.f12469h.addPostData("user_name", currentAccountName);
                                                            }
                                                            String a3 = k.c().a();
                                                            if (!StringUtils.isNull(a3)) {
                                                                if (b3 == 2) {
                                                                    this.f12469h.addPostData("forum_name", a3);
                                                                }
                                                                a2 = k.c().a();
                                                                if (!StringUtils.isNull(a2)) {
                                                                    this.f12469h.addPostData("small_flow_fname", a2);
                                                                }
                                                                postMultiNetData = this.f12469h.postMultiNetData(true);
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
                                                                        } catch (Exception e10) {
                                                                            exc = e10;
                                                                            imageUploadResult4 = parser;
                                                                            randomAccessFile = randomAccessFile3;
                                                                            sb = sb2;
                                                                            ImageUploadResult imageUploadResult82 = imageUploadResult4;
                                                                            c2 = 0;
                                                                            str2 = str6;
                                                                            netWork = null;
                                                                            imageUploadResult6 = imageUploadResult82;
                                                                            if (!this.f12467f) {
                                                                            }
                                                                            if (imageUploadResult6 != null) {
                                                                            }
                                                                            if (imageUploadResult2 != null) {
                                                                            }
                                                                            if (imageUploadResult2 == null) {
                                                                            }
                                                                            Object[] objArr2222 = new Object[2];
                                                                            objArr2222[c2] = "comment";
                                                                            objArr2222[1] = sb.toString();
                                                                            c.a.s0.s.c0.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr2222);
                                                                            StringBuilder sb42222 = new StringBuilder();
                                                                            sb42222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb42222.append(r3);
                                                                            sb42222.append(" ");
                                                                            sb42222.append(r2);
                                                                            sb42222.append(str2);
                                                                            str3 = str;
                                                                            sb42222.append(str3);
                                                                            c.a.t0.x3.s0.c.a(sb42222.toString());
                                                                            c.a.d.f.m.a.b(randomAccessFile);
                                                                            this.f12469h = netWork;
                                                                            imageUploadResult = imageUploadResult2;
                                                                            c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                                                                            return imageUploadResult;
                                                                        }
                                                                    }
                                                                    try {
                                                                        try {
                                                                            if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                                                c.a.t0.x3.s0.c.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + parser.error_code + str6 + str5);
                                                                                if (i7 == parser.chunkNo || parser.chunkNo <= 0) {
                                                                                    break;
                                                                                }
                                                                                i7 = parser.chunkNo;
                                                                                imageUploadResult5 = parser;
                                                                                j5 = length;
                                                                                str4 = str7;
                                                                                i6 = i8 + 1;
                                                                                sb = sb2;
                                                                                c2 = 0;
                                                                                options = options2;
                                                                            } else {
                                                                                StringBuilder sb5 = sb2;
                                                                                try {
                                                                                    if (ImageUploadResult.shouldReply(parser.error_code)) {
                                                                                        sb = sb5;
                                                                                        imageUploadResult5 = parser;
                                                                                        j5 = length;
                                                                                        str4 = str7;
                                                                                        options = options2;
                                                                                        i6 = i8 + 1;
                                                                                        c2 = 0;
                                                                                    } else {
                                                                                        int i10 = i7 + 1;
                                                                                        j6 += i4;
                                                                                        long j8 = i10 > 1 ? j6 + ((i10 - 1) * this.a) : j6;
                                                                                        if (this.o != null) {
                                                                                            this.o.hasUploadFileSize += i4;
                                                                                        }
                                                                                        c.a.t0.x3.s0.c.a("发帖：正在上传图片 已上传 = " + j8 + str6 + str5);
                                                                                        if (this.f12470i != null) {
                                                                                            try {
                                                                                                RandomAccessFile randomAccessFile8 = randomAccessFile3;
                                                                                                j3 = j8;
                                                                                                options = options2;
                                                                                                long j9 = j2;
                                                                                                bArr2 = bArr;
                                                                                                j4 = j9;
                                                                                                randomAccessFile = randomAccessFile8;
                                                                                                imageUploadResult5 = parser;
                                                                                                j5 = length;
                                                                                                sb = sb5;
                                                                                                str4 = str7;
                                                                                                netWork2 = null;
                                                                                            } catch (Exception e11) {
                                                                                                randomAccessFile = randomAccessFile3;
                                                                                                sb = sb5;
                                                                                                exc = e11;
                                                                                                str2 = str6;
                                                                                                imageUploadResult6 = parser;
                                                                                                netWork = null;
                                                                                                c2 = 0;
                                                                                            } catch (Throwable th7) {
                                                                                                th = th7;
                                                                                                randomAccessFile4 = randomAccessFile3;
                                                                                                netWork = null;
                                                                                                randomAccessFile6 = randomAccessFile4;
                                                                                                c.a.d.f.m.a.b(randomAccessFile6);
                                                                                                this.f12469h = netWork;
                                                                                                throw th;
                                                                                            }
                                                                                            try {
                                                                                                this.f12470i.a(str, this.k, j3, j5);
                                                                                            } catch (Exception e12) {
                                                                                                exc = e12;
                                                                                                str2 = str6;
                                                                                                imageUploadResult6 = imageUploadResult5;
                                                                                                c2 = 0;
                                                                                                netWork = null;
                                                                                            } catch (Throwable th8) {
                                                                                                th = th8;
                                                                                                netWork = null;
                                                                                                randomAccessFile6 = randomAccessFile;
                                                                                                c.a.d.f.m.a.b(randomAccessFile6);
                                                                                                this.f12469h = netWork;
                                                                                                throw th;
                                                                                            }
                                                                                        } else {
                                                                                            imageUploadResult5 = parser;
                                                                                            j5 = length;
                                                                                            str4 = str7;
                                                                                            sb = sb5;
                                                                                            netWork2 = null;
                                                                                            options = options2;
                                                                                            long j10 = j2;
                                                                                            bArr2 = bArr;
                                                                                            randomAccessFile = randomAccessFile3;
                                                                                            j4 = j10;
                                                                                            j3 = j8;
                                                                                        }
                                                                                        try {
                                                                                            if (this.f12471j != null) {
                                                                                                long j11 = j3;
                                                                                                str2 = str6;
                                                                                                c2 = 0;
                                                                                                netWork = netWork2;
                                                                                                i5 = i10;
                                                                                                this.f12471j.a(str, this.k, j11, j5, i2, i3);
                                                                                            } else {
                                                                                                i5 = i10;
                                                                                                str2 = str6;
                                                                                                c2 = 0;
                                                                                                netWork = netWork2;
                                                                                            }
                                                                                            i7 = i5;
                                                                                            i6 = i8;
                                                                                            if (i6 > this.p) {
                                                                                                sb.append("|possbile dead loop found. tryCount=");
                                                                                                sb.append(i6);
                                                                                                sb.append(", chunkNo=");
                                                                                                sb.append(j4);
                                                                                                break;
                                                                                            }
                                                                                            i8 = i6;
                                                                                            j7 = j4;
                                                                                            imageUploadResult = imageUploadResult5;
                                                                                            str7 = str4;
                                                                                            str6 = str2;
                                                                                            options2 = options;
                                                                                            bArr3 = bArr2;
                                                                                            randomAccessFile7 = randomAccessFile;
                                                                                            length = j5;
                                                                                            z3 = true;
                                                                                            sb3 = sb;
                                                                                            str5 = str;
                                                                                        } catch (Exception e13) {
                                                                                            e = e13;
                                                                                            str2 = str6;
                                                                                            c2 = 0;
                                                                                            netWork = netWork2;
                                                                                            exc = e;
                                                                                            imageUploadResult6 = imageUploadResult5;
                                                                                            if (!this.f12467f) {
                                                                                            }
                                                                                            if (imageUploadResult6 != null) {
                                                                                            }
                                                                                            if (imageUploadResult2 != null) {
                                                                                            }
                                                                                            if (imageUploadResult2 == null) {
                                                                                            }
                                                                                            Object[] objArr22222 = new Object[2];
                                                                                            objArr22222[c2] = "comment";
                                                                                            objArr22222[1] = sb.toString();
                                                                                            c.a.s0.s.c0.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr22222);
                                                                                            StringBuilder sb422222 = new StringBuilder();
                                                                                            sb422222.append("发帖：正在上传图片 上传失败 = ");
                                                                                            sb422222.append(r3);
                                                                                            sb422222.append(" ");
                                                                                            sb422222.append(r2);
                                                                                            sb422222.append(str2);
                                                                                            str3 = str;
                                                                                            sb422222.append(str3);
                                                                                            c.a.t0.x3.s0.c.a(sb422222.toString());
                                                                                            c.a.d.f.m.a.b(randomAccessFile);
                                                                                            this.f12469h = netWork;
                                                                                            imageUploadResult = imageUploadResult2;
                                                                                            c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                                                                                            return imageUploadResult;
                                                                                        } catch (Throwable th9) {
                                                                                            th = th9;
                                                                                            netWork = netWork2;
                                                                                            th = th;
                                                                                            randomAccessFile6 = randomAccessFile;
                                                                                            c.a.d.f.m.a.b(randomAccessFile6);
                                                                                            this.f12469h = netWork;
                                                                                            throw th;
                                                                                        }
                                                                                    }
                                                                                } catch (Exception e14) {
                                                                                    e = e14;
                                                                                    sb = sb5;
                                                                                    imageUploadResult5 = parser;
                                                                                    randomAccessFile = randomAccessFile3;
                                                                                    c2 = 0;
                                                                                    str2 = str6;
                                                                                    netWork = null;
                                                                                    exc = e;
                                                                                    imageUploadResult6 = imageUploadResult5;
                                                                                    if (!this.f12467f) {
                                                                                    }
                                                                                    if (imageUploadResult6 != null) {
                                                                                    }
                                                                                    if (imageUploadResult2 != null) {
                                                                                    }
                                                                                    if (imageUploadResult2 == null) {
                                                                                    }
                                                                                    Object[] objArr222222 = new Object[2];
                                                                                    objArr222222[c2] = "comment";
                                                                                    objArr222222[1] = sb.toString();
                                                                                    c.a.s0.s.c0.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr222222);
                                                                                    StringBuilder sb4222222 = new StringBuilder();
                                                                                    sb4222222.append("发帖：正在上传图片 上传失败 = ");
                                                                                    sb4222222.append(r3);
                                                                                    sb4222222.append(" ");
                                                                                    sb4222222.append(r2);
                                                                                    sb4222222.append(str2);
                                                                                    str3 = str;
                                                                                    sb4222222.append(str3);
                                                                                    c.a.t0.x3.s0.c.a(sb4222222.toString());
                                                                                    c.a.d.f.m.a.b(randomAccessFile);
                                                                                    this.f12469h = netWork;
                                                                                    imageUploadResult = imageUploadResult2;
                                                                                    c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                                                                                    return imageUploadResult;
                                                                                }
                                                                            }
                                                                            if (i6 > this.p) {
                                                                            }
                                                                        } catch (Exception e15) {
                                                                            e = e15;
                                                                            exc = e;
                                                                            imageUploadResult6 = imageUploadResult5;
                                                                            if (!this.f12467f) {
                                                                            }
                                                                            if (imageUploadResult6 != null) {
                                                                            }
                                                                            if (imageUploadResult2 != null) {
                                                                            }
                                                                            if (imageUploadResult2 == null) {
                                                                            }
                                                                            Object[] objArr2222222 = new Object[2];
                                                                            objArr2222222[c2] = "comment";
                                                                            objArr2222222[1] = sb.toString();
                                                                            c.a.s0.s.c0.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr2222222);
                                                                            StringBuilder sb42222222 = new StringBuilder();
                                                                            sb42222222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb42222222.append(r3);
                                                                            sb42222222.append(" ");
                                                                            sb42222222.append(r2);
                                                                            sb42222222.append(str2);
                                                                            str3 = str;
                                                                            sb42222222.append(str3);
                                                                            c.a.t0.x3.s0.c.a(sb42222222.toString());
                                                                            c.a.d.f.m.a.b(randomAccessFile);
                                                                            this.f12469h = netWork;
                                                                            imageUploadResult = imageUploadResult2;
                                                                            c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                                                                            return imageUploadResult;
                                                                        }
                                                                    } catch (Throwable th10) {
                                                                        th = th10;
                                                                        th = th;
                                                                        randomAccessFile6 = randomAccessFile;
                                                                        c.a.d.f.m.a.b(randomAccessFile6);
                                                                        this.f12469h = netWork;
                                                                        throw th;
                                                                    }
                                                                    RandomAccessFile randomAccessFile9 = randomAccessFile3;
                                                                    str2 = str6;
                                                                    netWork = null;
                                                                    long j12 = j2;
                                                                    bArr2 = bArr;
                                                                    randomAccessFile = randomAccessFile9;
                                                                    j4 = j12;
                                                                } catch (Exception e16) {
                                                                    e = e16;
                                                                    imageUploadResult5 = parser;
                                                                    randomAccessFile = randomAccessFile3;
                                                                    sb = sb2;
                                                                }
                                                            }
                                                        }
                                                        a2 = k.c().a();
                                                        if (!StringUtils.isNull(a2)) {
                                                        }
                                                        postMultiNetData = this.f12469h.postMultiNetData(true);
                                                        parser = ImageUploadResult.parser(postMultiNetData);
                                                        if (postMultiNetData != null) {
                                                            break;
                                                        }
                                                        if (parser.error_code != 0) {
                                                        }
                                                        if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                        }
                                                        RandomAccessFile randomAccessFile92 = randomAccessFile3;
                                                        str2 = str6;
                                                        netWork = null;
                                                        long j122 = j2;
                                                        bArr2 = bArr;
                                                        randomAccessFile = randomAccessFile92;
                                                        j4 = j122;
                                                        if (i6 > this.p) {
                                                        }
                                                    } catch (Exception e17) {
                                                        e = e17;
                                                        randomAccessFile = randomAccessFile3;
                                                        sb = sb2;
                                                        c2 = 0;
                                                        str2 = str6;
                                                        netWork = null;
                                                        exc = e;
                                                        imageUploadResult6 = imageUploadResult;
                                                        if (!this.f12467f) {
                                                        }
                                                        if (imageUploadResult6 != null) {
                                                        }
                                                        if (imageUploadResult2 != null) {
                                                        }
                                                        if (imageUploadResult2 == null) {
                                                        }
                                                        Object[] objArr22222222 = new Object[2];
                                                        objArr22222222[c2] = "comment";
                                                        objArr22222222[1] = sb.toString();
                                                        c.a.s0.s.c0.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr22222222);
                                                        StringBuilder sb422222222 = new StringBuilder();
                                                        sb422222222.append("发帖：正在上传图片 上传失败 = ");
                                                        sb422222222.append(r3);
                                                        sb422222222.append(" ");
                                                        sb422222222.append(r2);
                                                        sb422222222.append(str2);
                                                        str3 = str;
                                                        sb422222222.append(str3);
                                                        c.a.t0.x3.s0.c.a(sb422222222.toString());
                                                        c.a.d.f.m.a.b(randomAccessFile);
                                                        this.f12469h = netWork;
                                                        imageUploadResult = imageUploadResult2;
                                                        c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                                                        return imageUploadResult;
                                                    }
                                                } catch (Throwable th11) {
                                                    th = th11;
                                                    randomAccessFile = randomAccessFile3;
                                                    netWork = null;
                                                    th = th;
                                                    randomAccessFile6 = randomAccessFile;
                                                    c.a.d.f.m.a.b(randomAccessFile6);
                                                    this.f12469h = netWork;
                                                    throw th;
                                                }
                                            } catch (Exception e18) {
                                                e = e18;
                                                randomAccessFile = randomAccessFile7;
                                                str2 = str6;
                                                sb = sb3;
                                            }
                                        }
                                        imageUploadResult = imageUploadResult5;
                                        randomAccessFile2 = randomAccessFile;
                                        c.a.d.f.m.a.b(randomAccessFile2);
                                        this.f12469h = netWork;
                                        str3 = str;
                                    } catch (Throwable th12) {
                                        th = th12;
                                        randomAccessFile = randomAccessFile7;
                                    }
                                } catch (Exception e19) {
                                    randomAccessFile = randomAccessFile7;
                                    str2 = "    p = ";
                                    sb = sb3;
                                    netWork = null;
                                    c2 = 0;
                                    exc = e19;
                                    imageUploadResult6 = null;
                                }
                            } catch (Exception e20) {
                                e = e20;
                                str2 = "    p = ";
                                sb = sb3;
                                netWork = null;
                                c2 = 0;
                                exc = e;
                                netWork3 = netWork;
                                randomAccessFile = netWork3;
                                imageUploadResult6 = netWork3;
                                if (!this.f12467f) {
                                }
                                if (imageUploadResult6 != null) {
                                }
                                if (imageUploadResult2 != null) {
                                }
                                if (imageUploadResult2 == null) {
                                }
                                Object[] objArr222222222 = new Object[2];
                                objArr222222222[c2] = "comment";
                                objArr222222222[1] = sb.toString();
                                c.a.s0.s.c0.a.a("img", -1L, -1, "imageUpload", r3, r2, objArr222222222);
                                StringBuilder sb4222222222 = new StringBuilder();
                                sb4222222222.append("发帖：正在上传图片 上传失败 = ");
                                sb4222222222.append(r3);
                                sb4222222222.append(" ");
                                sb4222222222.append(r2);
                                sb4222222222.append(str2);
                                str3 = str;
                                sb4222222222.append(str3);
                                c.a.t0.x3.s0.c.a(sb4222222222.toString());
                                c.a.d.f.m.a.b(randomAccessFile);
                                this.f12469h = netWork;
                                imageUploadResult = imageUploadResult2;
                                c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                                return imageUploadResult;
                            } catch (Throwable th13) {
                                th = th13;
                                netWork = null;
                                th = th;
                                randomAccessFile6 = netWork;
                                c.a.d.f.m.a.b(randomAccessFile6);
                                this.f12469h = netWork;
                                throw th;
                            }
                            c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                            return imageUploadResult;
                        }
                        ImageUploadResult imageUploadResult9 = new ImageUploadResult();
                        imageUploadResult9.error_code = -1007;
                        imageUploadResult9.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_not_exist);
                        TiebaStatic.imgError(-1007, "file error: " + imageUploadResult9.error_msg, sb.toString());
                        imageUploadResult = imageUploadResult9;
                        randomAccessFile2 = null;
                        c.a.d.f.m.a.b(randomAccessFile2);
                        this.f12469h = netWork;
                        str3 = str;
                        c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                        return imageUploadResult;
                    } catch (Throwable th14) {
                        th = th14;
                        th = th;
                        randomAccessFile6 = netWork;
                        c.a.d.f.m.a.b(randomAccessFile6);
                        this.f12469h = netWork;
                        throw th;
                    }
                    str2 = "    p = ";
                    sb = sb3;
                    c2 = 0;
                    netWork = null;
                }
                exc = e;
                imageUploadResult6 = imageUploadResult3;
                if (!this.f12467f) {
                    sb.append("|request cancelled.");
                } else {
                    BdLog.e(exc.getMessage());
                }
                if (imageUploadResult6 != null) {
                    imageUploadResult2 = new ImageUploadResult();
                    imageUploadResult2.error_code = -1002;
                    imageUploadResult2.error_msg = exc.getMessage();
                } else {
                    imageUploadResult2 = imageUploadResult6;
                }
                int i11 = imageUploadResult2 != null ? imageUploadResult2.error_code : -1002;
                String message = imageUploadResult2 == null ? imageUploadResult2.error_msg : exc.getMessage();
                Object[] objArr2222222222 = new Object[2];
                objArr2222222222[c2] = "comment";
                objArr2222222222[1] = sb.toString();
                c.a.s0.s.c0.a.a("img", -1L, -1, "imageUpload", i11, message, objArr2222222222);
                StringBuilder sb42222222222 = new StringBuilder();
                sb42222222222.append("发帖：正在上传图片 上传失败 = ");
                sb42222222222.append(i11);
                sb42222222222.append(" ");
                sb42222222222.append(message);
                sb42222222222.append(str2);
                str3 = str;
                sb42222222222.append(str3);
                c.a.t0.x3.s0.c.a(sb42222222222.toString());
                c.a.d.f.m.a.b(randomAccessFile);
                this.f12469h = netWork;
                imageUploadResult = imageUploadResult2;
                c.a.t0.x3.s0.c.a("发帖：上传图片 结束      p = " + str3);
                return imageUploadResult;
            }
            c.a.t0.x3.s0.c.a("发帖：正在上传图片 失败 = " + str5);
            ImageUploadResult imageUploadResult10 = new ImageUploadResult();
            imageUploadResult10.error_code = -1007;
            imageUploadResult10.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
            return imageUploadResult10;
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
                if (this.f12467f) {
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
            c.a.t0.x3.s0.c.a("发帖： 上传批量图片到server");
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
                fVar.p = writeImagesInfo.imageChunkRetry;
                if (fVar.n.getAsyncPublishStatData() != null && fVar.n.startPublishTime() > 0 && writeImagesInfo.needImageParallel) {
                    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(writeImagesInfo.imageUploadConcurrency);
                    h hVar = new h();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    while (i2 < linkedList.size()) {
                        g gVar = new g(hVar, linkedList, writeImagesInfo, z, i2);
                        gVar.c(fVar.n);
                        ArrayList arrayList3 = arrayList;
                        gVar.b(fVar.a, fVar.f12463b, fVar.f12464c, fVar.f12465d, fVar.f12466e, fVar.f12467f, fVar.q, fVar.f12468g, fVar.f12470i, fVar.f12471j, fVar.k, fVar.m, fVar.p);
                        arrayList2.add(gVar);
                        arrayList3.add(new FutureTask<>(gVar));
                        i2++;
                        fVar = this;
                        arrayList = arrayList3;
                        linkedList = linkedList;
                        newFixedThreadPool = newFixedThreadPool;
                        hVar = hVar;
                    }
                    ExecutorService executorService = newFixedThreadPool;
                    h hVar2 = hVar;
                    ArrayList<FutureTask<Boolean>> arrayList4 = arrayList;
                    hVar2.c(arrayList4);
                    hVar2.b(arrayList2);
                    for (FutureTask<Boolean> futureTask : arrayList4) {
                        executorService.submit(futureTask);
                    }
                    for (FutureTask<Boolean> futureTask2 : arrayList4) {
                        try {
                            futureTask2.get();
                        } catch (Exception unused) {
                        }
                    }
                    executorService.shutdown();
                    return hVar2.f12479c;
                }
                LinkedList linkedList2 = linkedList;
                int i4 = 0;
                while (i4 < linkedList2.size()) {
                    LinkedList linkedList3 = linkedList2;
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) linkedList3.get(i4);
                    imageFileInfo2.setTempUploadFileName(null);
                    c.a.t0.x3.s0.c.a("发帖：发送图片 上传图片 = " + i4 + " = " + imageFileInfo2.toJson().toString());
                    if (this.f12467f) {
                        break;
                    }
                    boolean isOriginalImg = imageFileInfo2.getImageType() == 1 ? false : writeImagesInfo.isOriginalImg();
                    c.a.t0.x3.s0.a.m(this.n, imageFileInfo2);
                    int i5 = i4 + 1;
                    ImageUploadResult k = k(imageFileInfo2, isOriginalImg, z, i5, linkedList3.size());
                    c.a.t0.x3.s0.a.d(this.n, imageFileInfo2, k);
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
                            c.a.t0.x3.s0.c.a("发帖：发送图片 上传图片 错误 1= " + i4 + " = " + imageFileInfo2.toJson().toString());
                            return errorData;
                        }
                    } else {
                        errorData.setError_code(-52);
                        errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        c.a.t0.x3.s0.c.a("发帖：发送图片 上传图片 错误 2= " + i4 + " = " + imageFileInfo2.toJson().toString());
                        return errorData;
                    }
                }
                c.a.t0.x3.s0.c.a("发帖：发送图片 上传图片 成功返回");
                return null;
            }
            errorData.setError_code(-1002);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
            c.a.t0.x3.s0.c.a("发帖：发送图片 上传图片 错误 无图");
            return errorData;
        }
        return (ErrorData) invokeLZ.objValue;
    }
}
