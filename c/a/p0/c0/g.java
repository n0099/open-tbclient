package c.a.p0.c0;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import c.a.e.e.p.q;
import c.a.p0.c0.f;
import c.a.p0.s.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
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
/* loaded from: classes3.dex */
public class g implements Callable<Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public h f13002e;

    /* renamed from: f  reason: collision with root package name */
    public LinkedList<ImageFileInfo> f13003f;

    /* renamed from: g  reason: collision with root package name */
    public WriteImagesInfo f13004g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13005h;

    /* renamed from: i  reason: collision with root package name */
    public int f13006i;

    /* renamed from: j  reason: collision with root package name */
    public int f13007j;
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
    public NetWork v;
    public e w;
    public WriteData x;

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
        this.v = null;
        this.f13002e = hVar;
        this.f13003f = linkedList;
        this.f13004g = writeImagesInfo;
        this.f13005h = z;
        this.f13006i = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Boolean call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ErrorData errorData = new ErrorData();
            ImageFileInfo imageFileInfo = this.f13003f.get(this.f13006i);
            if (TextUtils.isEmpty(imageFileInfo.getTempUploadFileName())) {
                imageFileInfo.setTempUploadFileName("img_upload_temp_file_" + this.f13006i + XAdSimpleImageLoader.TEMP_SUFFIX);
            }
            c.a.q0.i3.r0.h.a("发帖：发送图片 上传图片 = " + this.f13006i + " = " + imageFileInfo.toJson().toString());
            boolean isOriginalImg = imageFileInfo.getImageType() == 1 ? false : this.f13004g.isOriginalImg();
            c.a.q0.i3.r0.d.m(this.x, imageFileInfo);
            ImageUploadResult e2 = e(imageFileInfo, isOriginalImg, this.f13005h, this.f13006i + 1, this.f13003f.size());
            c.a.q0.i3.r0.d.d(this.x, imageFileInfo, e2);
            if (e2 != null) {
                UploadedImageInfo uploadedPicInfo = e2.getUploadedPicInfo();
                if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                    uploadedPicInfo.isGif = imageFileInfo.isGif();
                    uploadedPicInfo.isBJH = this.u;
                    imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                    return Boolean.TRUE;
                }
                errorData.setError_code(e2.error_code);
                errorData.setError_msg(e2.error_msg);
                c.a.q0.i3.r0.h.a("发帖：发送图片 上传图片 错误 1= " + this.f13006i + " = " + imageFileInfo.toJson().toString());
                this.f13002e.a(errorData);
                return Boolean.FALSE;
            }
            errorData.setError_code(-52);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
            c.a.q0.i3.r0.h.a("发帖：发送图片 上传图片 错误 2= " + this.f13006i + " = " + imageFileInfo.toJson().toString());
            this.f13002e.a(errorData);
            return Boolean.FALSE;
        }
        return (Boolean) invokeV.objValue;
    }

    public void b() {
        NetWork netWork;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (netWork = this.v) == null) {
            return;
        }
        netWork.cancelNetConnect();
    }

    public void c(int i2, int i3, int i4, int i5, int i6, boolean z, int i7, String str, f.a aVar, f.b bVar, Object obj, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Boolean.valueOf(z), Integer.valueOf(i7), str, aVar, bVar, obj, Boolean.valueOf(z2)}) == null) {
            this.f13007j = i2;
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
        }
    }

    public void d(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
            this.x = writeData;
        }
    }

    public final ImageUploadResult e(ImageFileInfo imageFileInfo, boolean z, boolean z2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.w == null) {
                this.w = new e();
            }
            return f(this.w.j(this.x, imageFileInfo, z), z, z2, i2, i3);
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:112:0x02b8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:265:0x039c */
    /* JADX WARN: Can't wrap try/catch for region: R(12:43|(13:47|48|(1:50)(1:273)|51|52|53|54|(2:55|(4:57|58|59|(1:258)(24:61|(1:63)(5:(2:252|253)(1:(2:239|240)(1:251))|(2:242|243)|249|250|245)|64|65|(5:218|219|220|221|222)(2:67|68)|69|70|(2:72|73)(1:216)|74|(1:78)|79|80|(1:82)|83|(1:85)(1:208)|86|87|(1:89)|(6:91|(1:93)|94|(1:98)|99|(6:101|(1:103)|104|(1:106)|107|(5:110|111|(3:188|189|(1:191))|113|(2:115|(5:119|120|121|122|(2:125|126)(1:124))(1:146))(15:147|148|(2:150|151)(1:187)|152|153|(1:155)(1:182)|156|(5:170|171|172|173|174)(1:158)|159|160|(3:162|163|164)(1:166)|165|121|122|(0)(0)))(2:206|205)))|207|104|(0)|107|(1:206)(5:110|111|(0)|113|(0)(0))))(1:266))|127|128|129|36|37)|274|275|276|277|278|279|280|129|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0379, code lost:
        r8 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x037d, code lost:
        r8.append(r26);
        r8.append(r4);
        c.a.q0.i3.r0.h.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r11);
        r11 = r7;
        r29 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x049e, code lost:
        r11 = r7;
        r29 = r17;
        r15 = r27;
        r15.append(r26);
        r15.append(r4);
        r15.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x04b2, code lost:
        if (r11 != null) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x04b4, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x04b6, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x04b7, code lost:
        r15.append(r7);
        r15.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x04bf, code lost:
        if (r11 == null) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x04c1, code lost:
        r15.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x04e7, code lost:
        r29 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x053e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x053f, code lost:
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0541, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x054c, code lost:
        r3 = r0;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x054e, code lost:
        r29 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0164, code lost:
        r9 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0166, code lost:
        r9.append("|startChunk=");
        r9.append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01aa, code lost:
        if (r15.length != r10) goto L249;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0309 A[Catch: all -> 0x01f2, Exception -> 0x01f8, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x01f8, blocks: (B:76:0x01ea, B:92:0x0218, B:97:0x0257, B:99:0x025b, B:102:0x028d, B:105:0x0298, B:111:0x02ad, B:113:0x02ba, B:115:0x02c4, B:116:0x02cd, B:120:0x02da, B:121:0x02e1, B:125:0x02f2, B:130:0x0309), top: B:271:0x01ea }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x033b A[Catch: all -> 0x01f2, Exception -> 0x032a, TRY_ENTER, TryCatch #2 {Exception -> 0x032a, blocks: (B:136:0x0322, B:144:0x033b, B:146:0x035b, B:149:0x0360), top: B:269:0x0322 }] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0476 A[LOOP:0: B:41:0x0159->B:187:0x0476, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0554 A[Catch: all -> 0x05dd, TryCatch #27 {all -> 0x05dd, blocks: (B:239:0x0550, B:241:0x0554, B:245:0x0565, B:247:0x0574, B:249:0x0578, B:251:0x057f, B:250:0x057b, B:242:0x055a, B:184:0x045a, B:186:0x0465, B:169:0x040a, B:177:0x0435, B:179:0x0439, B:181:0x044f, B:195:0x049e, B:199:0x04b7, B:201:0x04c1), top: B:299:0x045a }] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x055a A[Catch: all -> 0x05dd, TryCatch #27 {all -> 0x05dd, blocks: (B:239:0x0550, B:241:0x0554, B:245:0x0565, B:247:0x0574, B:249:0x0578, B:251:0x057f, B:250:0x057b, B:242:0x055a, B:184:0x045a, B:186:0x0465, B:169:0x040a, B:177:0x0435, B:179:0x0439, B:181:0x044f, B:195:0x049e, B:199:0x04b7, B:201:0x04c1), top: B:299:0x045a }] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0565 A[Catch: all -> 0x05dd, TryCatch #27 {all -> 0x05dd, blocks: (B:239:0x0550, B:241:0x0554, B:245:0x0565, B:247:0x0574, B:249:0x0578, B:251:0x057f, B:250:0x057b, B:242:0x055a, B:184:0x045a, B:186:0x0465, B:169:0x040a, B:177:0x0435, B:179:0x0439, B:181:0x044f, B:195:0x049e, B:199:0x04b7, B:201:0x04c1), top: B:299:0x045a }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0574 A[Catch: all -> 0x05dd, TryCatch #27 {all -> 0x05dd, blocks: (B:239:0x0550, B:241:0x0554, B:245:0x0565, B:247:0x0574, B:249:0x0578, B:251:0x057f, B:250:0x057b, B:242:0x055a, B:184:0x045a, B:186:0x0465, B:169:0x040a, B:177:0x0435, B:179:0x0439, B:181:0x044f, B:195:0x049e, B:199:0x04b7, B:201:0x04c1), top: B:299:0x045a }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0578 A[Catch: all -> 0x05dd, TryCatch #27 {all -> 0x05dd, blocks: (B:239:0x0550, B:241:0x0554, B:245:0x0565, B:247:0x0574, B:249:0x0578, B:251:0x057f, B:250:0x057b, B:242:0x055a, B:184:0x045a, B:186:0x0465, B:169:0x040a, B:177:0x0435, B:179:0x0439, B:181:0x044f, B:195:0x049e, B:199:0x04b7, B:201:0x04c1), top: B:299:0x045a }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x057b A[Catch: all -> 0x05dd, TryCatch #27 {all -> 0x05dd, blocks: (B:239:0x0550, B:241:0x0554, B:245:0x0565, B:247:0x0574, B:249:0x0578, B:251:0x057f, B:250:0x057b, B:242:0x055a, B:184:0x045a, B:186:0x0465, B:169:0x040a, B:177:0x0435, B:179:0x0439, B:181:0x044f, B:195:0x049e, B:199:0x04b7, B:201:0x04c1), top: B:299:0x045a }] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x039c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0322 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0465 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult f(String str, boolean z, boolean z2, int i2, int i3) {
        InterceptResult invokeCommon;
        StringBuilder sb;
        char c2;
        Throwable th;
        RandomAccessFile randomAccessFile;
        Exception exc;
        ImageUploadResult imageUploadResult;
        RandomAccessFile randomAccessFile2;
        String str2;
        File file;
        long length;
        ImageUploadResult imageUploadResult2;
        RandomAccessFile randomAccessFile3;
        StringBuilder sb2;
        String str3;
        int i4;
        long j2;
        RandomAccessFile randomAccessFile4;
        ?? r8;
        StringBuilder sb3;
        String a2;
        String postMultiNetData;
        ImageUploadResult parser;
        ImageUploadResult imageUploadResult3;
        StringBuilder sb4;
        int i5;
        long j3;
        int i6;
        ImageUploadResult imageUploadResult4;
        long j4;
        int i7;
        long j5;
        String str4;
        StringBuilder sb5;
        BitmapFactory.Options options;
        long j6;
        byte[] bArr;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            String str5 = str;
            c.a.q0.i3.r0.h.a("发帖：正在上传图片 = " + str5);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            boolean z3 = true;
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str5, options2);
            byte[] bArr2 = null;
            if (options2.outWidth != 0 && options2.outHeight != 0) {
                StringBuilder sb6 = new StringBuilder();
                try {
                    try {
                        file = new File(str5);
                        length = file.length();
                        try {
                            try {
                            } catch (Exception e2) {
                                exc = e2;
                                imageUploadResult = null;
                                randomAccessFile2 = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    sb = sb6;
                    c2 = 0;
                }
                if ((!z && length > 5242880) || (z && length > 10485760)) {
                    imageUploadResult = new ImageUploadResult();
                    try {
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                        c.a.q0.i3.r0.h.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str5);
                        c.a.e.e.m.a.b(null);
                        this.v = null;
                        return imageUploadResult;
                    } catch (Exception e4) {
                        exc = e4;
                        randomAccessFile2 = null;
                        c2 = 0;
                        sb = sb6;
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
                        c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr);
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("发帖：正在上传图片 上传失败 = ");
                        sb7.append(r4);
                        sb7.append(" ");
                        sb7.append(r3);
                        sb7.append("    p = ");
                        str2 = str;
                        sb7.append(str2);
                        c.a.q0.i3.r0.h.a(sb7.toString());
                        c.a.e.e.m.a.b(randomAccessFile2);
                        this.v = null;
                        c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                        return imageUploadResult;
                    }
                }
                c.a.q0.i3.r0.h.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str5);
                String b2 = q.b(FileHelper.GetStreamFromFile(file));
                sb6.append("path=");
                sb6.append(str5);
                sb6.append("|length=");
                sb6.append(length);
                sb6.append("|md5=");
                sb6.append(b2);
                if (length != 0 && b2 != null) {
                    String str6 = b2 + this.f13007j;
                    long j7 = length % ((long) this.f13007j) == 0 ? length / this.f13007j : (length / this.f13007j) + 1;
                    sb6.append("|chunkNo=");
                    sb6.append(j7);
                    randomAccessFile = new RandomAccessFile(str5, r.f42169a);
                    try {
                        try {
                            sb6.append("|width=");
                            sb6.append(this.k);
                            sb6.append("|height=");
                            sb6.append(this.l);
                            sb6.append("|smallWidth=");
                            sb6.append(this.m);
                            sb6.append("|smallHeight=");
                            sb6.append(this.n);
                            sb6.append("|groupId=");
                            sb6.append(this.q);
                            StringBuilder sb8 = sb6;
                            imageUploadResult2 = null;
                            int i9 = 1;
                            long j8 = 0;
                            int i10 = 0;
                            while (true) {
                                int i11 = (i9 > j7 ? 1 : (i9 == j7 ? 0 : -1));
                                if (i11 > 0) {
                                    break;
                                }
                                try {
                                    if (this.o == z3) {
                                        break;
                                    }
                                    StringBuilder sb9 = sb8;
                                    if (i11 > 0) {
                                        j2 = j7;
                                        sb2 = sb9;
                                        str3 = "|startChunk=";
                                        i4 = 0;
                                        bArr2 = null;
                                    } else {
                                        if (i11 < 0) {
                                            try {
                                                try {
                                                    sb2 = sb9;
                                                    str3 = "|startChunk=";
                                                    i4 = this.f13007j;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    th = th;
                                                    c.a.e.e.m.a.b(randomAccessFile);
                                                    this.v = null;
                                                    throw th;
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                                randomAccessFile2 = randomAccessFile;
                                                imageUploadResult = imageUploadResult2;
                                                sb = sb9;
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
                                                c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr2);
                                                StringBuilder sb72 = new StringBuilder();
                                                sb72.append("发帖：正在上传图片 上传失败 = ");
                                                sb72.append(r4);
                                                sb72.append(" ");
                                                sb72.append(r3);
                                                sb72.append("    p = ");
                                                str2 = str;
                                                sb72.append(str2);
                                                c.a.q0.i3.r0.h.a(sb72.toString());
                                                c.a.e.e.m.a.b(randomAccessFile2);
                                                this.v = null;
                                                c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                                                return imageUploadResult;
                                            }
                                        } else if (i11 == 0) {
                                            sb2 = sb9;
                                            str3 = "|startChunk=";
                                            i4 = (int) (length - (this.f13007j * (j7 - 1)));
                                        } else {
                                            sb2 = sb9;
                                            str3 = "|startChunk=";
                                            i4 = 0;
                                        }
                                        if (bArr2 != null) {
                                            try {
                                            } catch (Exception e6) {
                                                e = e6;
                                                randomAccessFile2 = randomAccessFile;
                                                imageUploadResult = imageUploadResult2;
                                                sb = sb2;
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
                                                c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr22);
                                                StringBuilder sb722 = new StringBuilder();
                                                sb722.append("发帖：正在上传图片 上传失败 = ");
                                                sb722.append(r4);
                                                sb722.append(" ");
                                                sb722.append(r3);
                                                sb722.append("    p = ");
                                                str2 = str;
                                                sb722.append(str2);
                                                c.a.q0.i3.r0.h.a(sb722.toString());
                                                c.a.e.e.m.a.b(randomAccessFile2);
                                                this.v = null;
                                                c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                                                return imageUploadResult;
                                            }
                                        }
                                        try {
                                            bArr2 = new byte[i4];
                                            j2 = j7;
                                            randomAccessFile.seek(this.f13007j * (i9 - 1));
                                            randomAccessFile.read(bArr2, 0, i4);
                                        } catch (Exception e7) {
                                            e = e7;
                                            randomAccessFile2 = randomAccessFile;
                                            sb = sb2;
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
                                            c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr222);
                                            StringBuilder sb7222 = new StringBuilder();
                                            sb7222.append("发帖：正在上传图片 上传失败 = ");
                                            sb7222.append(r4);
                                            sb7222.append(" ");
                                            sb7222.append(r3);
                                            sb7222.append("    p = ");
                                            str2 = str;
                                            sb7222.append(str2);
                                            c.a.q0.i3.r0.h.a(sb7222.toString());
                                            c.a.e.e.m.a.b(randomAccessFile2);
                                            this.v = null;
                                            c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                                            return imageUploadResult;
                                        }
                                    }
                                    NetWork netWork = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                    this.v = netWork;
                                    String str7 = str6;
                                    netWork.addPostData("resourceId", str7);
                                    this.v.addPostData("chunkNo", String.valueOf(i9));
                                    if (i11 >= 0) {
                                        try {
                                            randomAccessFile4 = randomAccessFile;
                                            try {
                                                try {
                                                    this.v.addPostData("isFinish", String.valueOf(1));
                                                } catch (Exception e8) {
                                                    e = e8;
                                                    imageUploadResult = imageUploadResult2;
                                                    randomAccessFile2 = randomAccessFile4;
                                                    sb = sb2;
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
                                                    c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr2222);
                                                    StringBuilder sb72222 = new StringBuilder();
                                                    sb72222.append("发帖：正在上传图片 上传失败 = ");
                                                    sb72222.append(r4);
                                                    sb72222.append(" ");
                                                    sb72222.append(r3);
                                                    sb72222.append("    p = ");
                                                    str2 = str;
                                                    sb72222.append(str2);
                                                    c.a.q0.i3.r0.h.a(sb72222.toString());
                                                    c.a.e.e.m.a.b(randomAccessFile2);
                                                    this.v = null;
                                                    c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                                                    return imageUploadResult;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                randomAccessFile = randomAccessFile4;
                                                c.a.e.e.m.a.b(randomAccessFile);
                                                this.v = null;
                                                throw th;
                                            }
                                        } catch (Exception e9) {
                                            e = e9;
                                            randomAccessFile4 = randomAccessFile;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            th = th;
                                            c.a.e.e.m.a.b(randomAccessFile);
                                            this.v = null;
                                            throw th;
                                        }
                                    } else {
                                        randomAccessFile4 = randomAccessFile;
                                        this.v.addPostData("isFinish", String.valueOf(0));
                                    }
                                    if (this.u) {
                                        this.v.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(1));
                                        r8 = 0;
                                    } else {
                                        r8 = 0;
                                        this.v.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(0));
                                    }
                                    this.v.addPostData("size", String.valueOf(length));
                                    this.v.addPostData("width", String.valueOf(options2.outWidth));
                                    this.v.addPostData("height", String.valueOf(options2.outHeight));
                                    if (this.m > 0 && this.n > 0) {
                                        this.v.addPostData("smallWidth", String.valueOf(this.m));
                                        this.v.addPostData("smallHeight", String.valueOf(this.n));
                                    }
                                    try {
                                        try {
                                            this.v.addPostData(TbEnum.SystemMessage.KEY_GROUP_ID, String.valueOf(this.q));
                                            this.v.addPostData("alt", "json");
                                            if (bArr2 != null) {
                                                this.v.addPostData("chunk", bArr2);
                                            }
                                            if (z) {
                                                this.v.addPostData("saveOrigin", "1");
                                            } else {
                                                this.v.addPostData("saveOrigin", "0");
                                            }
                                            if (this.p != 0) {
                                                this.v.addPostData("pic_water_type", String.valueOf(this.p));
                                            }
                                            if (z2) {
                                                int b3 = k.c().b();
                                                if (b3 != 0) {
                                                    this.v.addPostData("pic_water_type", String.valueOf(b3));
                                                }
                                                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                if (!StringUtils.isNull(currentAccountName) && b3 == 1) {
                                                    this.v.addPostData("user_name", currentAccountName);
                                                }
                                                String a3 = k.c().a();
                                                r8 = StringUtils.isNull(a3);
                                                if (r8 == 0) {
                                                    sb3 = r8;
                                                    if (b3 == 2) {
                                                        this.v.addPostData("forum_name", a3);
                                                        sb3 = "forum_name";
                                                    }
                                                    a2 = k.c().a();
                                                    StringBuilder sb10 = sb3;
                                                    if (!StringUtils.isNull(a2)) {
                                                        this.v.addPostData("small_flow_fname", a2);
                                                        sb10 = "small_flow_fname";
                                                    }
                                                    postMultiNetData = this.v.postMultiNetData();
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
                                                                imageUploadResult = parser;
                                                                randomAccessFile2 = randomAccessFile4;
                                                                sb = sb2;
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
                                                                c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr22222);
                                                                StringBuilder sb722222 = new StringBuilder();
                                                                sb722222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb722222.append(r4);
                                                                sb722222.append(" ");
                                                                sb722222.append(r3);
                                                                sb722222.append("    p = ");
                                                                str2 = str;
                                                                sb722222.append(str2);
                                                                c.a.q0.i3.r0.h.a(sb722222.toString());
                                                                c.a.e.e.m.a.b(randomAccessFile2);
                                                                this.v = null;
                                                                c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                                                                return imageUploadResult;
                                                            }
                                                        }
                                                        if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                            c.a.q0.i3.r0.h.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + parser.error_code + "    p = " + str5);
                                                            if (i9 == parser.chunkNo || parser.chunkNo <= 0) {
                                                                break;
                                                            }
                                                            i9 = parser.chunkNo;
                                                            j5 = length;
                                                            imageUploadResult3 = parser;
                                                            str4 = str7;
                                                            bArr = bArr2;
                                                            sb = sb2;
                                                            c2 = 0;
                                                            long j9 = j2;
                                                            options = options2;
                                                            randomAccessFile2 = randomAccessFile4;
                                                            j6 = j9;
                                                            try {
                                                                try {
                                                                    i8 = i10 + 1;
                                                                    if (i8 <= 2 * j6) {
                                                                        sb.append("|possbile dead loop found. tryCount=");
                                                                        sb.append(i8);
                                                                        sb.append(", chunkNo=");
                                                                        sb.append(j6);
                                                                        break;
                                                                    }
                                                                    i10 = i8;
                                                                    imageUploadResult2 = imageUploadResult3;
                                                                    j7 = j6;
                                                                    sb8 = sb;
                                                                    str6 = str4;
                                                                    bArr2 = bArr;
                                                                    options2 = options;
                                                                    randomAccessFile = randomAccessFile2;
                                                                    length = j5;
                                                                    z3 = true;
                                                                    str5 = str;
                                                                } catch (Exception e11) {
                                                                    e = e11;
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
                                                                    c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, objArr222222);
                                                                    StringBuilder sb7222222 = new StringBuilder();
                                                                    sb7222222.append("发帖：正在上传图片 上传失败 = ");
                                                                    sb7222222.append(r4);
                                                                    sb7222222.append(" ");
                                                                    sb7222222.append(r3);
                                                                    sb7222222.append("    p = ");
                                                                    str2 = str;
                                                                    sb7222222.append(str2);
                                                                    c.a.q0.i3.r0.h.a(sb7222222.toString());
                                                                    c.a.e.e.m.a.b(randomAccessFile2);
                                                                    this.v = null;
                                                                    c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                                                                    return imageUploadResult;
                                                                }
                                                            } catch (Throwable th7) {
                                                                th = th7;
                                                                th = th;
                                                                randomAccessFile = randomAccessFile2;
                                                                c.a.e.e.m.a.b(randomAccessFile);
                                                                this.v = null;
                                                                throw th;
                                                            }
                                                        } else {
                                                            try {
                                                                sb4 = sb2;
                                                                i5 = i9 + 1;
                                                                j8 += i4;
                                                                j3 = i5 > 1 ? j8 + ((i5 - 1) * this.f13007j) : j8;
                                                            } catch (Exception e12) {
                                                                exc = e12;
                                                                imageUploadResult = parser;
                                                                sb = sb10;
                                                                randomAccessFile2 = randomAccessFile4;
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
                                                                c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", i12, message, objArr2222222);
                                                                StringBuilder sb72222222 = new StringBuilder();
                                                                sb72222222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb72222222.append(i12);
                                                                sb72222222.append(" ");
                                                                sb72222222.append(message);
                                                                sb72222222.append("    p = ");
                                                                str2 = str;
                                                                sb72222222.append(str2);
                                                                c.a.q0.i3.r0.h.a(sb72222222.toString());
                                                                c.a.e.e.m.a.b(randomAccessFile2);
                                                                this.v = null;
                                                                c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                                                                return imageUploadResult;
                                                            }
                                                            try {
                                                                if (this.f13004g != null) {
                                                                    i6 = i5;
                                                                    this.f13004g.hasUploadFileSize += i4;
                                                                } else {
                                                                    i6 = i5;
                                                                }
                                                                c.a.q0.i3.r0.h.a("发帖：正在上传图片 已上传 = " + j3 + "    p = " + str5);
                                                                if (this.r != null) {
                                                                    try {
                                                                        j4 = j3;
                                                                        RandomAccessFile randomAccessFile5 = randomAccessFile4;
                                                                        i7 = i6;
                                                                        j5 = length;
                                                                        imageUploadResult4 = parser;
                                                                        str4 = str7;
                                                                        c2 = 0;
                                                                        sb5 = sb4;
                                                                        long j10 = j2;
                                                                        options = options2;
                                                                        randomAccessFile2 = randomAccessFile5;
                                                                        j6 = j10;
                                                                        try {
                                                                            this.r.a(str, this.t, j4, j5);
                                                                        } catch (Exception e13) {
                                                                            exc = e13;
                                                                            sb = sb5;
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
                                                                            c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", i12, message, objArr22222222);
                                                                            StringBuilder sb722222222 = new StringBuilder();
                                                                            sb722222222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb722222222.append(i12);
                                                                            sb722222222.append(" ");
                                                                            sb722222222.append(message);
                                                                            sb722222222.append("    p = ");
                                                                            str2 = str;
                                                                            sb722222222.append(str2);
                                                                            c.a.q0.i3.r0.h.a(sb722222222.toString());
                                                                            c.a.e.e.m.a.b(randomAccessFile2);
                                                                            this.v = null;
                                                                            c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                                                                            return imageUploadResult;
                                                                        }
                                                                    } catch (Exception e14) {
                                                                        imageUploadResult4 = parser;
                                                                        randomAccessFile2 = randomAccessFile4;
                                                                        c2 = 0;
                                                                        exc = e14;
                                                                        sb = sb4;
                                                                    }
                                                                } else {
                                                                    j4 = j3;
                                                                    j5 = length;
                                                                    imageUploadResult4 = parser;
                                                                    c2 = 0;
                                                                    sb5 = sb4;
                                                                    int i13 = i6;
                                                                    str4 = str7;
                                                                    long j11 = j2;
                                                                    options = options2;
                                                                    randomAccessFile2 = randomAccessFile4;
                                                                    i7 = i13;
                                                                    j6 = j11;
                                                                }
                                                            } catch (Exception e15) {
                                                                e = e15;
                                                                imageUploadResult3 = parser;
                                                                sb = sb4;
                                                                randomAccessFile2 = randomAccessFile4;
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
                                                                Object[] objArr222222222 = new Object[2];
                                                                objArr222222222[c2] = "comment";
                                                                objArr222222222[1] = sb.toString();
                                                                c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", i12, message, objArr222222222);
                                                                StringBuilder sb7222222222 = new StringBuilder();
                                                                sb7222222222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb7222222222.append(i12);
                                                                sb7222222222.append(" ");
                                                                sb7222222222.append(message);
                                                                sb7222222222.append("    p = ");
                                                                str2 = str;
                                                                sb7222222222.append(str2);
                                                                c.a.q0.i3.r0.h.a(sb7222222222.toString());
                                                                c.a.e.e.m.a.b(randomAccessFile2);
                                                                this.v = null;
                                                                c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                                                                return imageUploadResult;
                                                            }
                                                            try {
                                                                if (this.s != null) {
                                                                    long j12 = j4;
                                                                    bArr = bArr2;
                                                                    imageUploadResult3 = imageUploadResult4;
                                                                    sb = sb5;
                                                                    this.s.a(str, this.t, j12, j5, i2, i3);
                                                                } else {
                                                                    imageUploadResult3 = imageUploadResult4;
                                                                    bArr = bArr2;
                                                                    sb = sb5;
                                                                }
                                                                i9 = i7;
                                                                i8 = i10 + 1;
                                                                if (i8 <= 2 * j6) {
                                                                }
                                                            } catch (Exception e16) {
                                                                e = e16;
                                                                sb = sb5;
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
                                                                Object[] objArr2222222222 = new Object[2];
                                                                objArr2222222222[c2] = "comment";
                                                                objArr2222222222[1] = sb.toString();
                                                                c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", i12, message, objArr2222222222);
                                                                StringBuilder sb72222222222 = new StringBuilder();
                                                                sb72222222222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb72222222222.append(i12);
                                                                sb72222222222.append(" ");
                                                                sb72222222222.append(message);
                                                                sb72222222222.append("    p = ");
                                                                str2 = str;
                                                                sb72222222222.append(str2);
                                                                c.a.q0.i3.r0.h.a(sb72222222222.toString());
                                                                c.a.e.e.m.a.b(randomAccessFile2);
                                                                this.v = null;
                                                                c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                                                                return imageUploadResult;
                                                            }
                                                        }
                                                    } catch (Exception e17) {
                                                        e = e17;
                                                        imageUploadResult3 = parser;
                                                        randomAccessFile2 = randomAccessFile4;
                                                        sb = sb2;
                                                    }
                                                }
                                            }
                                            sb3 = r8;
                                            a2 = k.c().a();
                                            StringBuilder sb102 = sb3;
                                            if (!StringUtils.isNull(a2)) {
                                            }
                                            postMultiNetData = this.v.postMultiNetData();
                                            parser = ImageUploadResult.parser(postMultiNetData);
                                            if (postMultiNetData != null) {
                                                break;
                                            }
                                            if (parser.error_code != 0) {
                                            }
                                            if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            randomAccessFile2 = randomAccessFile4;
                                        }
                                    } catch (Exception e18) {
                                        e = e18;
                                        randomAccessFile2 = randomAccessFile4;
                                        sb = sb2;
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
                                        c.a.p0.s.z.a.a("img", -1L, -1, "imageUpload", i12, message, objArr22222222222);
                                        StringBuilder sb722222222222 = new StringBuilder();
                                        sb722222222222.append("发帖：正在上传图片 上传失败 = ");
                                        sb722222222222.append(i12);
                                        sb722222222222.append(" ");
                                        sb722222222222.append(message);
                                        sb722222222222.append("    p = ");
                                        str2 = str;
                                        sb722222222222.append(str2);
                                        c.a.q0.i3.r0.h.a(sb722222222222.toString());
                                        c.a.e.e.m.a.b(randomAccessFile2);
                                        this.v = null;
                                        c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                                        return imageUploadResult;
                                    }
                                } catch (Exception e19) {
                                    e = e19;
                                    randomAccessFile2 = randomAccessFile;
                                    sb = sb8;
                                }
                            }
                            imageUploadResult2 = imageUploadResult3;
                            randomAccessFile3 = randomAccessFile2;
                            c.a.e.e.m.a.b(randomAccessFile3);
                            this.v = null;
                            imageUploadResult = imageUploadResult2;
                            str2 = str;
                        } catch (Throwable th9) {
                            th = th9;
                        }
                    } catch (Exception e20) {
                        randomAccessFile2 = randomAccessFile;
                        sb = sb6;
                        c2 = 0;
                        exc = e20;
                        imageUploadResult = null;
                    }
                    c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                    return imageUploadResult;
                }
                sb = sb6;
                c2 = 0;
                imageUploadResult = new ImageUploadResult();
                imageUploadResult.error_code = -1007;
                imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_not_exist);
                TiebaStatic.imgError(-1007, "file error: " + imageUploadResult.error_msg, sb.toString());
                imageUploadResult2 = imageUploadResult;
                randomAccessFile3 = null;
                c.a.e.e.m.a.b(randomAccessFile3);
                this.v = null;
                imageUploadResult = imageUploadResult2;
                str2 = str;
                c.a.q0.i3.r0.h.a("发帖：上传图片 结束      p = " + str2);
                return imageUploadResult;
            }
            c.a.q0.i3.r0.h.a("发帖：正在上传图片 失败 = " + str5);
            return null;
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }
}
