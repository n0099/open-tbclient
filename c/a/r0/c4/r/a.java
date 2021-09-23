package c.a.r0.c4.r;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.b.d;
import c.a.q0.d1.n0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.switchs.LimitLowQualityPicUploadSwitch;
import com.baidu.tieba.write.view.TitleTipView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f16852a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.c4.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0810a implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c f16853e;

        /* renamed from: f  reason: collision with root package name */
        public int f16854f;

        /* renamed from: g  reason: collision with root package name */
        public String f16855g;

        public C0810a(int i2, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16855g = "[^a-zA-Z0-9一-龥]";
            this.f16854f = i2;
            this.f16853e = cVar;
        }

        public final String a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? str2.replaceAll(str, "") : (String) invokeLL.objValue;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), spanned, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                if (spanned == null || charSequence == null) {
                    return charSequence;
                }
                String a2 = a(this.f16855g, charSequence.toString());
                int b2 = n0.b(spanned.toString()) - (i5 - i4);
                int b3 = n0.b(a2);
                int i6 = this.f16854f;
                int i7 = i6 - b2;
                if (b2 + b3 > i6) {
                    c cVar = this.f16853e;
                    if (cVar != null) {
                        cVar.a();
                    }
                    return StringHelper.cutChineseAndEnglishWithSuffix(a2, i7, "");
                }
                return a2;
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c f16856e;

        /* renamed from: f  reason: collision with root package name */
        public int f16857f;

        public b(int i2, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16857f = i2;
            this.f16856e = cVar;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), spanned, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                if (spanned == null || charSequence == null || (n0.c(spanned.toString()) - (i5 - i4)) + n0.c(charSequence.toString()) <= this.f16857f) {
                    return charSequence;
                }
                c cVar = this.f16856e;
                if (cVar != null) {
                    cVar.a();
                }
                return "";
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2001508694, "Lc/a/r0/c4/r/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2001508694, "Lc/a/r0/c4/r/a;");
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
            int k = c.a.q0.s.d0.b.j().k("key_upload_pic_max_width", 0);
            int k2 = c.a.q0.s.d0.b.j().k("key_upload_pic_max_height", 0);
            if (k <= 0 || k2 <= 0 || imageFileInfo == null || imageFileInfo.isGif() || (filePath = imageFileInfo.getFilePath()) == null) {
                return false;
            }
            int[] imageFileWH = FileHelper.getImageFileWH(filePath);
            return imageFileWH[0] >= k || imageFileWH[1] >= k2;
        }
        return invokeL.booleanValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? c.a.q0.s.d0.b.j().k("show_write_title_tip_count", 0) : invokeV.intValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? d.S() : invokeV.booleanValue;
    }

    public static void e(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, str) == null) {
            TiebaStatic.log(new StatisticItem("c14021").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", i2).param("obj_param1", str));
        }
    }

    public static void f(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, writeData) == null) || writeData == null || !d() || TextUtils.isEmpty(writeData.getTitle())) {
            return;
        }
        c.a.q0.s.d0.b.j().v("show_write_title_tip_count", c() + 1);
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            f16852a = true;
        }
    }

    public static void h(TitleTipView titleTipView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, titleTipView) == null) || titleTipView == null) {
            return;
        }
        if (d() && !f16852a && c() <= 0) {
            titleTipView.showAndAutoDissmiss();
            g();
            StatisticItem.make("c13996").eventStat();
            return;
        }
        titleTipView.setVisibility(8);
    }
}
