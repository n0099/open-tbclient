package c.a.o0.c0;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.q;
import c.a.o0.s.k;
import c.a.p0.i3.q0.h;
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
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f12720a;

    /* renamed from: b  reason: collision with root package name */
    public int f12721b;

    /* renamed from: c  reason: collision with root package name */
    public int f12722c;

    /* renamed from: d  reason: collision with root package name */
    public int f12723d;

    /* renamed from: e  reason: collision with root package name */
    public int f12724e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12725f;

    /* renamed from: g  reason: collision with root package name */
    public String f12726g;

    /* renamed from: h  reason: collision with root package name */
    public NetWork f12727h;

    /* renamed from: i  reason: collision with root package name */
    public a f12728i;

    /* renamed from: j  reason: collision with root package name */
    public b f12729j;
    public Object k;
    public e l;
    public boolean m;
    public WriteData n;
    public int o;

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
        this.f12720a = 512000;
        this.f12726g = "1";
        this.f12727h = null;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f12725f = true;
            NetWork netWork = this.f12727h;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f12726g = str;
        }
    }

    public void c(a aVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, obj) == null) {
            this.f12728i = aVar;
            this.k = obj;
            if (aVar != null) {
                this.f12720a = 10240;
            }
        }
    }

    public void d(b bVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, bVar, obj) == null) {
            this.f12729j = bVar;
            this.k = obj;
        }
    }

    public void e(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            this.f12721b = i2;
            this.f12722c = i3;
            this.f12723d = i4;
            this.f12724e = i5;
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.o = i2;
        }
    }

    public void g(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
            this.n = writeData;
        }
    }

    public ImageUploadResult h(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048583, this, imageFileInfo, z)) == null) ? i(imageFileInfo, false, z) : (ImageUploadResult) invokeLZ.objValue;
    }

    public ImageUploadResult i(ImageFileInfo imageFileInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? j(imageFileInfo, z, z2, 1, 1) : (ImageUploadResult) invokeCommon.objValue;
    }

    public final ImageUploadResult j(ImageFileInfo imageFileInfo, boolean z, boolean z2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.l == null) {
                this.l = new e();
            }
            return m(this.l.j(this.n, imageFileInfo, z), z, z2, i2, i3);
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    public ImageUploadResult k(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) ? l(str, false, z) : (ImageUploadResult) invokeLZ.objValue;
    }

    public ImageUploadResult l(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? m(str, z, z2, 1, 1) : (ImageUploadResult) invokeCommon.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:103:0x02a5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:273:0x037f */
    /* JADX WARN: Can't wrap try/catch for region: R(11:40|(13:44|45|(1:47)(1:251)|48|50|51|52|(2:53|(4:55|56|57|(1:237)(24:59|(1:61)(3:(2:230|231)(1:(2:221|222)(1:229))|(2:227|228)|226)|62|63|(5:201|202|203|204|205)(2:65|66)|67|68|(2:70|71)(1:199)|72|(1:76)|77|78|(1:80)|81|(1:83)(1:194)|84|85|(1:87)|(6:89|(1:91)|92|(1:96)|97|(6:99|(1:101)|102|(1:104)|105|(5:108|109|(3:174|175|(1:177))|111|(2:113|(5:117|118|119|120|(2:123|124)(1:122))(1:137))(13:138|139|(2:141|142)(1:173)|143|144|(5:158|159|160|161|162)(1:146)|147|148|(3:150|151|152)(1:154)|153|119|120|(0)(0)))(2:192|191)))|193|102|(0)|105|(1:192)(5:108|109|(0)|111|(0)(0))))(1:245))|240|126|127|32|33)|252|253|254|256|257|258|127|32|33) */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x035e, code lost:
        r8 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0362, code lost:
        r8.append(r26);
        r8.append(r4);
        c.a.p0.i3.q0.h.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r11);
        r11 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0457, code lost:
        r11 = r7;
        r13 = r27;
        r13.append(r26);
        r13.append(r4);
        r13.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0467, code lost:
        if (r11 != null) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0469, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x046b, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x046c, code lost:
        r13.append(r7);
        r13.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0474, code lost:
        if (r11 == null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0476, code lost:
        r13.append(r11.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x047b, code lost:
        r3 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x04e8, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x04e9, code lost:
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04eb, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x04f4, code lost:
        r3 = r0;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x04f6, code lost:
        r17 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0164, code lost:
        r9 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0166, code lost:
        r9.append("|startChunk=");
        r9.append(r4);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02f6 A[Catch: Exception -> 0x01f1, all -> 0x0578, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x01f1, blocks: (B:74:0x01e9, B:83:0x0205, B:88:0x0244, B:90:0x0248, B:93:0x027a, B:96:0x0285, B:102:0x029a, B:104:0x02a7, B:106:0x02b1, B:107:0x02ba, B:111:0x02c7, B:112:0x02ce, B:116:0x02df, B:121:0x02f6), top: B:252:0x01e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0324 A[Catch: Exception -> 0x0317, all -> 0x0578, TRY_ENTER, TryCatch #12 {all -> 0x0578, blocks: (B:220:0x04f8, B:222:0x04fc, B:225:0x050b, B:228:0x0512, B:230:0x0519, B:229:0x0515, B:223:0x0502, B:74:0x01e9, B:80:0x01ff, B:83:0x0205, B:86:0x021b, B:88:0x0244, B:90:0x0248, B:91:0x0262, B:93:0x027a, B:96:0x0285, B:99:0x0294, B:102:0x029a, B:104:0x02a7, B:106:0x02b1, B:107:0x02ba, B:111:0x02c7, B:112:0x02ce, B:116:0x02df, B:119:0x02e8, B:121:0x02f6, B:122:0x02fd, B:125:0x030b, B:127:0x030f, B:132:0x031e, B:134:0x0324, B:136:0x0344, B:139:0x0349, B:169:0x0419, B:171:0x0424, B:142:0x0362, B:143:0x037f, B:145:0x0389, B:150:0x039b, B:152:0x03b9, B:154:0x03d5, B:162:0x03f4, B:164:0x03f8, B:166:0x040e, B:179:0x0457, B:183:0x046c, B:185:0x0476, B:98:0x028d, B:85:0x0211, B:79:0x01f5), top: B:252:0x01e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0435 A[LOOP:0: B:40:0x0159->B:172:0x0435, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04fc A[Catch: all -> 0x0578, TryCatch #12 {all -> 0x0578, blocks: (B:220:0x04f8, B:222:0x04fc, B:225:0x050b, B:228:0x0512, B:230:0x0519, B:229:0x0515, B:223:0x0502, B:74:0x01e9, B:80:0x01ff, B:83:0x0205, B:86:0x021b, B:88:0x0244, B:90:0x0248, B:91:0x0262, B:93:0x027a, B:96:0x0285, B:99:0x0294, B:102:0x029a, B:104:0x02a7, B:106:0x02b1, B:107:0x02ba, B:111:0x02c7, B:112:0x02ce, B:116:0x02df, B:119:0x02e8, B:121:0x02f6, B:122:0x02fd, B:125:0x030b, B:127:0x030f, B:132:0x031e, B:134:0x0324, B:136:0x0344, B:139:0x0349, B:169:0x0419, B:171:0x0424, B:142:0x0362, B:143:0x037f, B:145:0x0389, B:150:0x039b, B:152:0x03b9, B:154:0x03d5, B:162:0x03f4, B:164:0x03f8, B:166:0x040e, B:179:0x0457, B:183:0x046c, B:185:0x0476, B:98:0x028d, B:85:0x0211, B:79:0x01f5), top: B:252:0x01e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0502 A[Catch: all -> 0x0578, TryCatch #12 {all -> 0x0578, blocks: (B:220:0x04f8, B:222:0x04fc, B:225:0x050b, B:228:0x0512, B:230:0x0519, B:229:0x0515, B:223:0x0502, B:74:0x01e9, B:80:0x01ff, B:83:0x0205, B:86:0x021b, B:88:0x0244, B:90:0x0248, B:91:0x0262, B:93:0x027a, B:96:0x0285, B:99:0x0294, B:102:0x029a, B:104:0x02a7, B:106:0x02b1, B:107:0x02ba, B:111:0x02c7, B:112:0x02ce, B:116:0x02df, B:119:0x02e8, B:121:0x02f6, B:122:0x02fd, B:125:0x030b, B:127:0x030f, B:132:0x031e, B:134:0x0324, B:136:0x0344, B:139:0x0349, B:169:0x0419, B:171:0x0424, B:142:0x0362, B:143:0x037f, B:145:0x0389, B:150:0x039b, B:152:0x03b9, B:154:0x03d5, B:162:0x03f4, B:164:0x03f8, B:166:0x040e, B:179:0x0457, B:183:0x046c, B:185:0x0476, B:98:0x028d, B:85:0x0211, B:79:0x01f5), top: B:252:0x01e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x050b A[Catch: all -> 0x0578, TryCatch #12 {all -> 0x0578, blocks: (B:220:0x04f8, B:222:0x04fc, B:225:0x050b, B:228:0x0512, B:230:0x0519, B:229:0x0515, B:223:0x0502, B:74:0x01e9, B:80:0x01ff, B:83:0x0205, B:86:0x021b, B:88:0x0244, B:90:0x0248, B:91:0x0262, B:93:0x027a, B:96:0x0285, B:99:0x0294, B:102:0x029a, B:104:0x02a7, B:106:0x02b1, B:107:0x02ba, B:111:0x02c7, B:112:0x02ce, B:116:0x02df, B:119:0x02e8, B:121:0x02f6, B:122:0x02fd, B:125:0x030b, B:127:0x030f, B:132:0x031e, B:134:0x0324, B:136:0x0344, B:139:0x0349, B:169:0x0419, B:171:0x0424, B:142:0x0362, B:143:0x037f, B:145:0x0389, B:150:0x039b, B:152:0x03b9, B:154:0x03d5, B:162:0x03f4, B:164:0x03f8, B:166:0x040e, B:179:0x0457, B:183:0x046c, B:185:0x0476, B:98:0x028d, B:85:0x0211, B:79:0x01f5), top: B:252:0x01e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0512 A[Catch: all -> 0x0578, TryCatch #12 {all -> 0x0578, blocks: (B:220:0x04f8, B:222:0x04fc, B:225:0x050b, B:228:0x0512, B:230:0x0519, B:229:0x0515, B:223:0x0502, B:74:0x01e9, B:80:0x01ff, B:83:0x0205, B:86:0x021b, B:88:0x0244, B:90:0x0248, B:91:0x0262, B:93:0x027a, B:96:0x0285, B:99:0x0294, B:102:0x029a, B:104:0x02a7, B:106:0x02b1, B:107:0x02ba, B:111:0x02c7, B:112:0x02ce, B:116:0x02df, B:119:0x02e8, B:121:0x02f6, B:122:0x02fd, B:125:0x030b, B:127:0x030f, B:132:0x031e, B:134:0x0324, B:136:0x0344, B:139:0x0349, B:169:0x0419, B:171:0x0424, B:142:0x0362, B:143:0x037f, B:145:0x0389, B:150:0x039b, B:152:0x03b9, B:154:0x03d5, B:162:0x03f4, B:164:0x03f8, B:166:0x040e, B:179:0x0457, B:183:0x046c, B:185:0x0476, B:98:0x028d, B:85:0x0211, B:79:0x01f5), top: B:252:0x01e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0515 A[Catch: all -> 0x0578, TryCatch #12 {all -> 0x0578, blocks: (B:220:0x04f8, B:222:0x04fc, B:225:0x050b, B:228:0x0512, B:230:0x0519, B:229:0x0515, B:223:0x0502, B:74:0x01e9, B:80:0x01ff, B:83:0x0205, B:86:0x021b, B:88:0x0244, B:90:0x0248, B:91:0x0262, B:93:0x027a, B:96:0x0285, B:99:0x0294, B:102:0x029a, B:104:0x02a7, B:106:0x02b1, B:107:0x02ba, B:111:0x02c7, B:112:0x02ce, B:116:0x02df, B:119:0x02e8, B:121:0x02f6, B:122:0x02fd, B:125:0x030b, B:127:0x030f, B:132:0x031e, B:134:0x0324, B:136:0x0344, B:139:0x0349, B:169:0x0419, B:171:0x0424, B:142:0x0362, B:143:0x037f, B:145:0x0389, B:150:0x039b, B:152:0x03b9, B:154:0x03d5, B:162:0x03f4, B:164:0x03f8, B:166:0x040e, B:179:0x0457, B:183:0x046c, B:185:0x0476, B:98:0x028d, B:85:0x0211, B:79:0x01f5), top: B:252:0x01e9 }] */
    /* JADX WARN: Removed duplicated region for block: B:271:0x030f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x037f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0424 A[SYNTHETIC] */
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
    public ImageUploadResult m(String str, boolean z, boolean z2, int i2, int i3) {
        InterceptResult invokeCommon;
        StringBuilder sb;
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
        ?? r8;
        StringBuilder sb3;
        String a2;
        String postMultiNetData;
        ImageUploadResult parser;
        ImageUploadResult imageUploadResult3;
        ImageUploadResult imageUploadResult4;
        long j3;
        int i5;
        long j4;
        String str4;
        StringBuilder sb4;
        byte[] bArr;
        long j5;
        BitmapFactory.Options options;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)})) != null) {
            return (ImageUploadResult) invokeCommon.objValue;
        }
        String str5 = str;
        h.a("发帖：正在上传图片 = " + str5);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        boolean z3 = true;
        options2.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str5, options2);
        byte[] bArr2 = null;
        if (options2.outWidth != 0 && options2.outHeight != 0) {
            StringBuilder sb5 = new StringBuilder();
            try {
                try {
                    file = new File(str5);
                    length = file.length();
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = null;
                }
            } catch (Exception e2) {
                e = e2;
                sb = sb5;
            }
            try {
                try {
                } catch (Exception e3) {
                    exc = e3;
                    sb = sb5;
                    imageUploadResult = null;
                    randomAccessFile2 = null;
                }
                if ((!z && length > 5242880) || (z && length > 10485760)) {
                    imageUploadResult = new ImageUploadResult();
                    try {
                        imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                        h.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str5);
                        c.a.e.e.m.a.b(null);
                        this.f12727h = null;
                        return imageUploadResult;
                    } catch (Exception e4) {
                        exc = e4;
                        sb = sb5;
                        randomAccessFile2 = null;
                    }
                } else {
                    h.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str5);
                    String b2 = q.b(FileHelper.GetStreamFromFile(file));
                    sb5.append("path=");
                    sb5.append(str5);
                    sb5.append("|length=");
                    sb5.append(length);
                    sb5.append("|md5=");
                    sb5.append(b2);
                    if (length != 0 && b2 != null) {
                        String str6 = b2 + this.f12720a;
                        long j6 = length % ((long) this.f12720a) == 0 ? length / this.f12720a : (length / this.f12720a) + 1;
                        sb5.append("|chunkNo=");
                        sb5.append(j6);
                        randomAccessFile = new RandomAccessFile(str5, r.f42062a);
                        try {
                            try {
                                sb5.append("|width=");
                                sb5.append(this.f12721b);
                                sb5.append("|height=");
                                sb5.append(this.f12722c);
                                sb5.append("|smallWidth=");
                                sb5.append(this.f12723d);
                                sb5.append("|smallHeight=");
                                sb5.append(this.f12724e);
                                sb5.append("|groupId=");
                                sb5.append(this.f12726g);
                                StringBuilder sb6 = sb5;
                                imageUploadResult2 = null;
                                int i7 = 1;
                                long j7 = 0;
                                int i8 = 0;
                                while (true) {
                                    int i9 = (i7 > j6 ? 1 : (i7 == j6 ? 0 : -1));
                                    if (i9 > 0) {
                                        break;
                                    }
                                    try {
                                        if (this.f12725f == z3) {
                                            break;
                                        }
                                        StringBuilder sb7 = sb6;
                                        if (i9 > 0) {
                                            j2 = j6;
                                            sb2 = sb7;
                                            str3 = "|startChunk=";
                                            i4 = 0;
                                            bArr2 = null;
                                        } else {
                                            if (i9 < 0) {
                                                try {
                                                    try {
                                                        sb2 = sb7;
                                                        str3 = "|startChunk=";
                                                        i4 = this.f12720a;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        th = th;
                                                        c.a.e.e.m.a.b(randomAccessFile);
                                                        this.f12727h = null;
                                                        throw th;
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    randomAccessFile2 = randomAccessFile;
                                                    imageUploadResult = imageUploadResult2;
                                                    sb = sb7;
                                                    exc = e;
                                                    if (!this.f12725f) {
                                                    }
                                                    if (imageUploadResult == null) {
                                                    }
                                                    if (imageUploadResult == null) {
                                                    }
                                                    c.a.o0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, "comment", sb.toString());
                                                    StringBuilder sb8 = new StringBuilder();
                                                    sb8.append("发帖：正在上传图片 上传失败 = ");
                                                    sb8.append(r4);
                                                    sb8.append(" ");
                                                    sb8.append(r3);
                                                    sb8.append("    p = ");
                                                    str2 = str;
                                                    sb8.append(str2);
                                                    h.a(sb8.toString());
                                                    c.a.e.e.m.a.b(randomAccessFile2);
                                                    this.f12727h = null;
                                                    h.a("发帖：上传图片 结束      p = " + str2);
                                                    return imageUploadResult;
                                                }
                                            } else if (i9 == 0) {
                                                sb2 = sb7;
                                                str3 = "|startChunk=";
                                                i4 = (int) (length - (this.f12720a * (j6 - 1)));
                                            } else {
                                                sb2 = sb7;
                                                str3 = "|startChunk=";
                                                i4 = 0;
                                            }
                                            if (bArr2 == null || bArr2.length != i4) {
                                                try {
                                                    bArr2 = new byte[i4];
                                                } catch (Exception e6) {
                                                    e = e6;
                                                    randomAccessFile2 = randomAccessFile;
                                                    sb = sb2;
                                                    imageUploadResult = imageUploadResult2;
                                                    exc = e;
                                                    if (!this.f12725f) {
                                                    }
                                                    if (imageUploadResult == null) {
                                                    }
                                                    if (imageUploadResult == null) {
                                                    }
                                                    c.a.o0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, "comment", sb.toString());
                                                    StringBuilder sb82 = new StringBuilder();
                                                    sb82.append("发帖：正在上传图片 上传失败 = ");
                                                    sb82.append(r4);
                                                    sb82.append(" ");
                                                    sb82.append(r3);
                                                    sb82.append("    p = ");
                                                    str2 = str;
                                                    sb82.append(str2);
                                                    h.a(sb82.toString());
                                                    c.a.e.e.m.a.b(randomAccessFile2);
                                                    this.f12727h = null;
                                                    h.a("发帖：上传图片 结束      p = " + str2);
                                                    return imageUploadResult;
                                                }
                                            }
                                            j2 = j6;
                                            randomAccessFile.seek(this.f12720a * (i7 - 1));
                                            randomAccessFile.read(bArr2, 0, i4);
                                        }
                                        NetWork netWork = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                        this.f12727h = netWork;
                                        String str7 = str6;
                                        netWork.addPostData("resourceId", str7);
                                        this.f12727h.addPostData("chunkNo", String.valueOf(i7));
                                        if (i9 >= 0) {
                                            try {
                                                randomAccessFile2 = randomAccessFile;
                                                try {
                                                    try {
                                                        this.f12727h.addPostData("isFinish", String.valueOf(1));
                                                    } catch (Exception e7) {
                                                        e = e7;
                                                        imageUploadResult = imageUploadResult2;
                                                        sb = sb2;
                                                        exc = e;
                                                        if (!this.f12725f) {
                                                        }
                                                        if (imageUploadResult == null) {
                                                        }
                                                        if (imageUploadResult == null) {
                                                        }
                                                        c.a.o0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, "comment", sb.toString());
                                                        StringBuilder sb822 = new StringBuilder();
                                                        sb822.append("发帖：正在上传图片 上传失败 = ");
                                                        sb822.append(r4);
                                                        sb822.append(" ");
                                                        sb822.append(r3);
                                                        sb822.append("    p = ");
                                                        str2 = str;
                                                        sb822.append(str2);
                                                        h.a(sb822.toString());
                                                        c.a.e.e.m.a.b(randomAccessFile2);
                                                        this.f12727h = null;
                                                        h.a("发帖：上传图片 结束      p = " + str2);
                                                        return imageUploadResult;
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    randomAccessFile = randomAccessFile2;
                                                    c.a.e.e.m.a.b(randomAccessFile);
                                                    this.f12727h = null;
                                                    throw th;
                                                }
                                            } catch (Exception e8) {
                                                e = e8;
                                                randomAccessFile2 = randomAccessFile;
                                            }
                                        } else {
                                            randomAccessFile2 = randomAccessFile;
                                            this.f12727h.addPostData("isFinish", String.valueOf(0));
                                        }
                                        if (this.m) {
                                            this.f12727h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(1));
                                            r8 = 0;
                                        } else {
                                            r8 = 0;
                                            this.f12727h.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(0));
                                        }
                                        this.f12727h.addPostData("size", String.valueOf(length));
                                        this.f12727h.addPostData("width", String.valueOf(options2.outWidth));
                                        this.f12727h.addPostData("height", String.valueOf(options2.outHeight));
                                        if (this.f12723d > 0 && this.f12724e > 0) {
                                            this.f12727h.addPostData("smallWidth", String.valueOf(this.f12723d));
                                            this.f12727h.addPostData("smallHeight", String.valueOf(this.f12724e));
                                        }
                                        try {
                                            this.f12727h.addPostData(TbEnum.SystemMessage.KEY_GROUP_ID, String.valueOf(this.f12726g));
                                            this.f12727h.addPostData("alt", "json");
                                            if (bArr2 != null) {
                                                this.f12727h.addPostData("chunk", bArr2);
                                            }
                                            if (z) {
                                                this.f12727h.addPostData("saveOrigin", "1");
                                            } else {
                                                this.f12727h.addPostData("saveOrigin", "0");
                                            }
                                            if (this.o != 0) {
                                                this.f12727h.addPostData("pic_water_type", String.valueOf(this.o));
                                            }
                                            if (z2) {
                                                int b3 = k.c().b();
                                                if (b3 != 0) {
                                                    this.f12727h.addPostData("pic_water_type", String.valueOf(b3));
                                                }
                                                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                if (!StringUtils.isNull(currentAccountName) && b3 == 1) {
                                                    this.f12727h.addPostData("user_name", currentAccountName);
                                                }
                                                String a3 = k.c().a();
                                                r8 = StringUtils.isNull(a3);
                                                if (r8 == 0) {
                                                    sb3 = r8;
                                                    if (b3 == 2) {
                                                        this.f12727h.addPostData("forum_name", a3);
                                                        sb3 = "forum_name";
                                                    }
                                                    a2 = k.c().a();
                                                    StringBuilder sb9 = sb3;
                                                    if (!StringUtils.isNull(a2)) {
                                                        this.f12727h.addPostData("small_flow_fname", a2);
                                                        sb9 = "small_flow_fname";
                                                    }
                                                    postMultiNetData = this.f12727h.postMultiNetData();
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
                                                            } catch (Exception e9) {
                                                                exc = e9;
                                                                imageUploadResult = parser;
                                                                sb = sb2;
                                                            }
                                                        }
                                                        if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                            h.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + parser.error_code + "    p = " + str5);
                                                            if (i7 == parser.chunkNo || parser.chunkNo <= 0) {
                                                                break;
                                                            }
                                                            i7 = parser.chunkNo;
                                                            j4 = length;
                                                            imageUploadResult3 = parser;
                                                            str4 = str7;
                                                            options = options2;
                                                            sb = sb2;
                                                            long j8 = j2;
                                                            bArr = bArr2;
                                                            j5 = j8;
                                                            try {
                                                                i6 = i8 + 1;
                                                                if (i6 <= 2 * j5) {
                                                                    sb.append("|possbile dead loop found. tryCount=");
                                                                    sb.append(i6);
                                                                    sb.append(", chunkNo=");
                                                                    sb.append(j5);
                                                                    break;
                                                                }
                                                                i8 = i6;
                                                                imageUploadResult2 = imageUploadResult3;
                                                                sb6 = sb;
                                                                j6 = j5;
                                                                randomAccessFile = randomAccessFile2;
                                                                options2 = options;
                                                                bArr2 = bArr;
                                                                length = j4;
                                                                z3 = true;
                                                                str5 = str;
                                                                str6 = str4;
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                exc = e;
                                                                imageUploadResult = imageUploadResult3;
                                                                if (!this.f12725f) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                if (imageUploadResult == null) {
                                                                }
                                                                c.a.o0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, "comment", sb.toString());
                                                                StringBuilder sb8222 = new StringBuilder();
                                                                sb8222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb8222.append(r4);
                                                                sb8222.append(" ");
                                                                sb8222.append(r3);
                                                                sb8222.append("    p = ");
                                                                str2 = str;
                                                                sb8222.append(str2);
                                                                h.a(sb8222.toString());
                                                                c.a.e.e.m.a.b(randomAccessFile2);
                                                                this.f12727h = null;
                                                                h.a("发帖：上传图片 结束      p = " + str2);
                                                                return imageUploadResult;
                                                            }
                                                        } else {
                                                            try {
                                                                StringBuilder sb10 = sb2;
                                                                int i10 = i7 + 1;
                                                                j7 += i4;
                                                                long j9 = i10 > 1 ? j7 + ((i10 - 1) * this.f12720a) : j7;
                                                                try {
                                                                    h.a("发帖：正在上传图片 已上传 = " + j9 + "    p = " + str5);
                                                                    if (this.f12728i != null) {
                                                                        try {
                                                                            j3 = j9;
                                                                            i5 = i10;
                                                                            j4 = length;
                                                                            imageUploadResult4 = parser;
                                                                            str4 = str7;
                                                                            sb4 = sb10;
                                                                            long j10 = j2;
                                                                            bArr = bArr2;
                                                                            j5 = j10;
                                                                        } catch (Exception e11) {
                                                                            imageUploadResult4 = parser;
                                                                            exc = e11;
                                                                            sb = sb10;
                                                                        }
                                                                        try {
                                                                            this.f12728i.a(str, this.k, j3, j4);
                                                                        } catch (Exception e12) {
                                                                            exc = e12;
                                                                            sb = sb4;
                                                                            imageUploadResult = imageUploadResult4;
                                                                            if (!this.f12725f) {
                                                                            }
                                                                            if (imageUploadResult == null) {
                                                                            }
                                                                            if (imageUploadResult == null) {
                                                                            }
                                                                            c.a.o0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, "comment", sb.toString());
                                                                            StringBuilder sb82222 = new StringBuilder();
                                                                            sb82222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb82222.append(r4);
                                                                            sb82222.append(" ");
                                                                            sb82222.append(r3);
                                                                            sb82222.append("    p = ");
                                                                            str2 = str;
                                                                            sb82222.append(str2);
                                                                            h.a(sb82222.toString());
                                                                            c.a.e.e.m.a.b(randomAccessFile2);
                                                                            this.f12727h = null;
                                                                            h.a("发帖：上传图片 结束      p = " + str2);
                                                                            return imageUploadResult;
                                                                        }
                                                                    } else {
                                                                        j3 = j9;
                                                                        i5 = i10;
                                                                        j4 = length;
                                                                        imageUploadResult4 = parser;
                                                                        str4 = str7;
                                                                        sb4 = sb10;
                                                                        long j11 = j2;
                                                                        bArr = bArr2;
                                                                        j5 = j11;
                                                                    }
                                                                } catch (Exception e13) {
                                                                    e = e13;
                                                                    imageUploadResult3 = parser;
                                                                    sb = sb10;
                                                                }
                                                                try {
                                                                    if (this.f12729j != null) {
                                                                        long j12 = j3;
                                                                        options = options2;
                                                                        imageUploadResult3 = imageUploadResult4;
                                                                        sb = sb4;
                                                                        this.f12729j.a(str, this.k, j12, j4, i2, i3);
                                                                    } else {
                                                                        imageUploadResult3 = imageUploadResult4;
                                                                        options = options2;
                                                                        sb = sb4;
                                                                    }
                                                                    i7 = i5;
                                                                    i6 = i8 + 1;
                                                                    if (i6 <= 2 * j5) {
                                                                    }
                                                                } catch (Exception e14) {
                                                                    e = e14;
                                                                    sb = sb4;
                                                                    imageUploadResult3 = imageUploadResult4;
                                                                    exc = e;
                                                                    imageUploadResult = imageUploadResult3;
                                                                    if (!this.f12725f) {
                                                                    }
                                                                    if (imageUploadResult == null) {
                                                                    }
                                                                    if (imageUploadResult == null) {
                                                                    }
                                                                    c.a.o0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, "comment", sb.toString());
                                                                    StringBuilder sb822222 = new StringBuilder();
                                                                    sb822222.append("发帖：正在上传图片 上传失败 = ");
                                                                    sb822222.append(r4);
                                                                    sb822222.append(" ");
                                                                    sb822222.append(r3);
                                                                    sb822222.append("    p = ");
                                                                    str2 = str;
                                                                    sb822222.append(str2);
                                                                    h.a(sb822222.toString());
                                                                    c.a.e.e.m.a.b(randomAccessFile2);
                                                                    this.f12727h = null;
                                                                    h.a("发帖：上传图片 结束      p = " + str2);
                                                                    return imageUploadResult;
                                                                }
                                                            } catch (Exception e15) {
                                                                exc = e15;
                                                                imageUploadResult = parser;
                                                                sb = sb9;
                                                            }
                                                        }
                                                    } catch (Exception e16) {
                                                        e = e16;
                                                        imageUploadResult3 = parser;
                                                        sb = sb2;
                                                    }
                                                }
                                            }
                                            sb3 = r8;
                                            a2 = k.c().a();
                                            StringBuilder sb92 = sb3;
                                            if (!StringUtils.isNull(a2)) {
                                            }
                                            postMultiNetData = this.f12727h.postMultiNetData();
                                            parser = ImageUploadResult.parser(postMultiNetData);
                                            if (postMultiNetData != null) {
                                                break;
                                            }
                                            if (parser.error_code != 0) {
                                            }
                                            if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                            }
                                        } catch (Exception e17) {
                                            e = e17;
                                            sb = sb2;
                                            imageUploadResult = imageUploadResult2;
                                            exc = e;
                                            if (!this.f12725f) {
                                            }
                                            if (imageUploadResult == null) {
                                            }
                                            if (imageUploadResult == null) {
                                            }
                                            c.a.o0.s.z.a.a("img", -1L, -1, "imageUpload", r4, r3, "comment", sb.toString());
                                            StringBuilder sb8222222 = new StringBuilder();
                                            sb8222222.append("发帖：正在上传图片 上传失败 = ");
                                            sb8222222.append(r4);
                                            sb8222222.append(" ");
                                            sb8222222.append(r3);
                                            sb8222222.append("    p = ");
                                            str2 = str;
                                            sb8222222.append(str2);
                                            h.a(sb8222222.toString());
                                            c.a.e.e.m.a.b(randomAccessFile2);
                                            this.f12727h = null;
                                            h.a("发帖：上传图片 结束      p = " + str2);
                                            return imageUploadResult;
                                        }
                                    } catch (Exception e18) {
                                        e = e18;
                                        randomAccessFile2 = randomAccessFile;
                                        sb = sb6;
                                    }
                                }
                                randomAccessFile2 = randomAccessFile;
                                randomAccessFile3 = randomAccessFile2;
                                c.a.e.e.m.a.b(randomAccessFile3);
                                this.f12727h = null;
                                imageUploadResult = imageUploadResult2;
                                str2 = str;
                            } catch (Exception e19) {
                                randomAccessFile2 = randomAccessFile;
                                sb = sb5;
                                exc = e19;
                                imageUploadResult = null;
                            }
                            h.a("发帖：上传图片 结束      p = " + str2);
                            return imageUploadResult;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    sb = sb5;
                    imageUploadResult = new ImageUploadResult();
                    imageUploadResult.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                    imageUploadResult.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_not_exist);
                    TiebaStatic.imgError(-1007, "file error: " + imageUploadResult.error_msg, sb.toString());
                    imageUploadResult2 = imageUploadResult;
                    randomAccessFile3 = null;
                    c.a.e.e.m.a.b(randomAccessFile3);
                    this.f12727h = null;
                    imageUploadResult = imageUploadResult2;
                    str2 = str;
                    h.a("发帖：上传图片 结束      p = " + str2);
                    return imageUploadResult;
                }
                h.a("发帖：上传图片 结束      p = " + str2);
                return imageUploadResult;
            } catch (Throwable th6) {
                th = th6;
                randomAccessFile = null;
            }
            if (!this.f12725f) {
                sb.append("|request cancelled.");
            } else {
                BdLog.e(exc.getMessage());
            }
            int i11 = imageUploadResult == null ? imageUploadResult.error_code : -1002;
            String message = imageUploadResult == null ? imageUploadResult.error_msg : exc.getMessage();
            c.a.o0.s.z.a.a("img", -1L, -1, "imageUpload", i11, message, "comment", sb.toString());
            StringBuilder sb82222222 = new StringBuilder();
            sb82222222.append("发帖：正在上传图片 上传失败 = ");
            sb82222222.append(i11);
            sb82222222.append(" ");
            sb82222222.append(message);
            sb82222222.append("    p = ");
            str2 = str;
            sb82222222.append(str2);
            h.a(sb82222222.toString());
            c.a.e.e.m.a.b(randomAccessFile2);
            this.f12727h = null;
        } else {
            h.a("发帖：正在上传图片 失败 = " + str5);
            return null;
        }
    }

    public void n(WriteImagesInfo writeImagesInfo, boolean z) {
        UploadedImageInfo uploadedPicInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048589, this, writeImagesInfo, z) == null) || writeImagesInfo == null || writeImagesInfo.size() == 0) {
            return;
        }
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        for (int i2 = 0; i2 < chosedFiles.size(); i2++) {
            ImageFileInfo imageFileInfo = chosedFiles.get(i2);
            if (imageFileInfo != null && !imageFileInfo.isAlreadyUploadedToServer()) {
                if (this.f12725f) {
                    return;
                }
                ImageUploadResult i3 = i(imageFileInfo, writeImagesInfo.isOriginalImg() || imageFileInfo.isGif(), z);
                if (i3 != null && (uploadedPicInfo = i3.getUploadedPicInfo()) != null) {
                    imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                    imageFileInfo.serverPicInfo = i3.picInfo;
                }
            }
        }
    }

    public ErrorData o(WriteImagesInfo writeImagesInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, writeImagesInfo, z)) == null) {
            h.a("发帖： 上传批量图片到server");
            ErrorData errorData = new ErrorData();
            if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
                LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < chosedFiles.size(); i2++) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                    if (!imageFileInfo.isAlreadyUploadedToServer()) {
                        linkedList.add(imageFileInfo);
                    }
                }
                int i3 = 0;
                while (i3 < linkedList.size()) {
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) linkedList.get(i3);
                    h.a("发帖：发送图片 上传图片 = " + i3 + " = " + imageFileInfo2.toJson().toString());
                    if (this.f12725f) {
                        break;
                    }
                    boolean isOriginalImg = imageFileInfo2.getImageType() == 1 ? false : writeImagesInfo.isOriginalImg();
                    c.a.p0.i3.q0.d.m(this.n, imageFileInfo2);
                    int i4 = i3 + 1;
                    ImageUploadResult j2 = j(imageFileInfo2, isOriginalImg, z, i4, linkedList.size());
                    c.a.p0.i3.q0.d.d(this.n, imageFileInfo2, j2);
                    if (j2 != null) {
                        UploadedImageInfo uploadedPicInfo = j2.getUploadedPicInfo();
                        if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                            uploadedPicInfo.isGif = imageFileInfo2.isGif();
                            uploadedPicInfo.isBJH = this.m;
                            imageFileInfo2.setServerImageCode(uploadedPicInfo.toPostString());
                            i3 = i4;
                        } else {
                            errorData.setError_code(j2.error_code);
                            errorData.setError_msg(j2.error_msg);
                            h.a("发帖：发送图片 上传图片 错误 1= " + i3 + " = " + imageFileInfo2.toJson().toString());
                            return errorData;
                        }
                    } else {
                        errorData.setError_code(-53);
                        errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        h.a("发帖：发送图片 上传图片 错误 2= " + i3 + " = " + imageFileInfo2.toJson().toString());
                        return errorData;
                    }
                }
                h.a("发帖：发送图片 上传图片 成功返回");
                return null;
            }
            errorData.setError_code(-53);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
            h.a("发帖：发送图片 上传图片 错误 无图");
            return errorData;
        }
        return (ErrorData) invokeLZ.objValue;
    }
}
