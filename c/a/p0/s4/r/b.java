package c.a.p0.s4.r;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.o0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.switchs.LimitLowQualityPicUploadSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;

        /* renamed from: b  reason: collision with root package name */
        public int f18425b;

        /* renamed from: c  reason: collision with root package name */
        public String f18426c;

        public a(int i, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18426c = "[^a-zA-Z0-9一-龥]";
            this.f18425b = i;
            this.a = cVar;
        }

        public final String a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? str2.replaceAll(str, "") : (String) invokeLL.objValue;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                if (spanned == null || charSequence == null) {
                    return charSequence;
                }
                String a = a(this.f18426c, charSequence.toString());
                int b2 = o0.b(spanned.toString()) - (i4 - i3);
                int b3 = o0.b(a);
                int i5 = this.f18425b;
                int i6 = i5 - b2;
                if (b2 + b3 > i5) {
                    c cVar = this.a;
                    if (cVar != null) {
                        cVar.a();
                    }
                    return StringHelper.cutChineseAndEnglishWithSuffix(a, i6, "");
                }
                return a;
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    /* renamed from: c.a.p0.s4.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1393b implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;

        /* renamed from: b  reason: collision with root package name */
        public EditText f18427b;

        /* renamed from: c  reason: collision with root package name */
        public int f18428c;

        public C1393b(EditText editText, int i, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editText, Integer.valueOf(i), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18427b = editText;
            this.f18428c = i;
            this.a = cVar;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                if (spanned == null || charSequence == null || " ".equals(charSequence)) {
                    return charSequence;
                }
                int c2 = o0.c(spanned.toString()) - (i4 - i3);
                int c3 = o0.c(charSequence.toString());
                if (TextUtils.isEmpty(this.f18427b.getText()) || (c2 + c3) - o0.j(this.f18427b.getText().toString()) <= this.f18428c) {
                    return charSequence;
                }
                c cVar = this.a;
                if (cVar != null) {
                    cVar.a();
                }
                return "";
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-293324645, "Lc/a/p0/s4/r/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-293324645, "Lc/a/p0/s4/r/b;");
        }
    }

    public static boolean a(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        String filePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, imageFileInfo)) == null) {
            if (!LimitLowQualityPicUploadSwitch.isOff() && imageFileInfo != null && !imageFileInfo.isGif() && (filePath = imageFileInfo.getFilePath()) != null) {
                long fileSize = FileHelper.getFileSize(filePath);
                if (fileSize < 5120) {
                    e(1, "" + fileSize);
                    return true;
                }
                int[] imageFileWH = FileHelper.getImageFileWH(filePath);
                if (imageFileWH[0] < 100 || imageFileWH[1] < 100) {
                    e(2, imageFileWH[0] + "*" + imageFileWH[1]);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(ImageFileInfo imageFileInfo) {
        InterceptResult invokeL;
        String filePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, imageFileInfo)) == null) {
            int l = c.a.o0.r.j0.b.k().l("key_upload_pic_max_width", 0);
            int l2 = c.a.o0.r.j0.b.k().l("key_upload_pic_max_height", 0);
            if (l <= 0 || l2 <= 0 || imageFileInfo == null || imageFileInfo.isGif() || (filePath = imageFileInfo.getFilePath()) == null) {
                return false;
            }
            int[] imageFileWH = FileHelper.getImageFileWH(filePath);
            return imageFileWH[0] >= l || imageFileWH[1] >= l2;
        }
        return invokeL.booleanValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.a.o0.r.j0.b.k().l("show_write_title_tip_count", 0) : invokeV.intValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? UbsABTestHelper.isShowWriteTitleTest() : invokeV.booleanValue;
    }

    public static void e(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, null, i, str) == null) {
            TiebaStatic.log(new StatisticItem("c14021").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i).param("obj_param1", str));
        }
    }

    public static void f(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, writeData) == null) || writeData == null || !d() || TextUtils.isEmpty(writeData.getTitle())) {
            return;
        }
        c.a.o0.r.j0.b.k().w("show_write_title_tip_count", c() + 1);
    }
}
