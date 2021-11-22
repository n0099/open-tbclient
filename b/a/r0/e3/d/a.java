package b.a.r0.e3.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.i;
import b.a.e.a.j;
import b.a.e.f.p.l;
import b.a.q0.j0.h;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.mutiprocess.share.ShareEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes4.dex */
public abstract class a implements b.a.r0.e3.e.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static String f17309e;

    /* renamed from: f  reason: collision with root package name */
    public static String f17310f;

    /* renamed from: g  reason: collision with root package name */
    public static String f17311g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f17312a;

    /* renamed from: b  reason: collision with root package name */
    public Context f17313b;

    /* renamed from: c  reason: collision with root package name */
    public String f17314c;

    /* renamed from: d  reason: collision with root package name */
    public String f17315d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(250011068, "Lb/a/r0/e3/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(250011068, "Lb/a/r0/e3/d/a;");
                return;
            }
        }
        f17309e = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share";
        f17310f = "temp_video_thumb.png";
        f17311g = "_temp_share_pic.png";
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f17313b = context;
    }

    public void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            ShareEvent shareEvent = new ShareEvent();
            shareEvent.status = i2;
            shareEvent.tid = this.f17314c;
            shareEvent.channel = i3;
            shareEvent.extLiveInfo = this.f17315d;
            h.i(shareEvent);
        }
    }

    public Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbadkCoreApplication.getInst().getContext() : (Context) invokeV.objValue;
    }

    public Bitmap d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? BitmapHelper.getCashBitmap(R.drawable.tb_launcher_icon) : (Bitmap) invokeV.objValue;
    }

    public Bitmap e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? BitmapHelper.getCashBitmap(i2) : (Bitmap) invokeI.objValue;
    }

    public Bitmap f(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uri)) == null) ? BitmapHelper.loadBitmap(uri.getPath()) : (Bitmap) invokeL.objValue;
    }

    public Bitmap g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? BitmapHelper.loadBitmap(str) : (Bitmap) invokeL.objValue;
    }

    public BdUniqueId h() {
        InterceptResult invokeV;
        i c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BdUniqueId bdUniqueId = this.f17312a;
            return (bdUniqueId == null && (c2 = j.c(this.f17313b)) != null) ? c2.getUniqueId() : bdUniqueId;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public Bitmap i(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, bitmap, i2)) == null) ? BitmapHelper.resizeBitmap(bitmap, i2, i2, false) : (Bitmap) invokeLI.objValue;
    }

    public Bitmap j(Bitmap bitmap, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap, i2, i3)) == null) ? BitmapHelper.resizeBitmap(bitmap, i2, i3, false) : (Bitmap) invokeLII.objValue;
    }

    public String k(int i2, Object... objArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, objArr)) == null) ? c().getString(i2, objArr) : (String) invokeIL.objValue;
    }

    public void l(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, intent) == null) {
        }
    }

    public boolean m(Uri uri) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, uri)) == null) {
            if (uri == null) {
                return false;
            }
            try {
                file = new File(new URI(uri.toString()));
            } catch (IllegalArgumentException | URISyntaxException unused) {
            }
            return file.isFile() && file.exists();
        }
        return invokeL.booleanValue;
    }

    public boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            return file.isFile() && file.exists();
        }
        return invokeL.booleanValue;
    }

    public b.a.e.m.d.a o(ShareEntity shareEntity) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, shareEntity)) == null) {
            if (shareEntity == null || (bundle = shareEntity.diskPicOperate) == null) {
                return null;
            }
            String string = bundle.getString("path");
            String string2 = bundle.getString("name");
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                return null;
            }
            boolean z = bundle.getBoolean("isSubDir", true);
            boolean z2 = bundle.getBoolean("isSdcard", false);
            boolean z3 = bundle.getBoolean("isSavedCache", true);
            boolean z4 = bundle.getBoolean("formatData", true);
            b.a.e.f.a.f.c cVar = new b.a.e.f.a.f.c(string, string2, DiskFileOperate.Action.READ);
            cVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            cVar.setSubFolder(z);
            cVar.setIsFormatData(z4);
            cVar.setSdCard(z2);
            cVar.setSavedCache(z3);
            if (b.a.e.f.a.d.f().call(cVar) && cVar.isSuccess()) {
                cVar.formatData(cVar.getData());
                Bitmap bitmap = cVar.getBitmap();
                if (bitmap != null) {
                    return new b.a.e.m.d.a(bitmap, cVar.isGif());
                }
                return null;
            }
            return null;
        }
        return (b.a.e.m.d.a) invokeL.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bdUniqueId) == null) {
            this.f17312a = bdUniqueId;
        }
    }

    public Bitmap r(Bitmap bitmap, ShareEntity shareEntity, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048592, this, bitmap, shareEntity, z)) == null) {
            if (bitmap == null) {
                return null;
            }
            Bitmap i2 = i(bitmap, (l.g(this.f17313b, R.dimen.tbds113) * Math.max(bitmap.getWidth(), bitmap.getHeight())) / Math.min(bitmap.getWidth(), bitmap.getHeight()));
            Bitmap createBitmap = Bitmap.createBitmap(i2.getWidth(), i2.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(i2, 0.0f, 0.0f, (Paint) null);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, 0.0f, i2.getHeight(), this.f17313b.getResources().getColor(R.color.CAM_X0601), this.f17313b.getResources().getColor(R.color.CAM_X0605), Shader.TileMode.CLAMP);
            Paint paint = new Paint();
            paint.setShader(linearGradient);
            canvas.drawRect(0.0f, 0.0f, i2.getWidth(), i2.getHeight(), paint);
            Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_share_play_20, R.color.CAM_X0101, null, false);
            if (pureDrawable != null) {
                int min = (int) (Math.min(i2.getWidth(), i2.getHeight()) * 0.3f);
                int width = (i2.getWidth() - min) / 2;
                int height = (i2.getHeight() - min) / 2;
                pureDrawable.setBounds(width, height, width + min, min + height);
                pureDrawable.draw(canvas);
            }
            if (z) {
                String saveFileAsPNG = FileHelper.saveFileAsPNG(f17309e, f17310f, createBitmap, 100);
                if (!StringUtils.isNull(saveFileAsPNG)) {
                    shareEntity.setImageUri(Uri.parse(saveFileAsPNG));
                }
            }
            return createBitmap;
        }
        return (Bitmap) invokeLLZ.objValue;
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.f17315d = str;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.f17314c = str;
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            y(str, R.drawable.icon_toast_game_error);
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            y(str, R.drawable.icon_toast_game_ok);
        }
    }

    public void w(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i2, i3) == null) {
            x(i2, null, i3);
        }
    }

    public void x(int i2, String str, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
            if (i2 == 1) {
                if (TextUtils.isEmpty(str)) {
                    str = k(R.string.share_success, new Object[0]);
                }
                v(str);
            } else if (i2 == 3) {
                if (TextUtils.isEmpty(str)) {
                    str = k(R.string.share_cancel, new Object[0]);
                }
                u(str);
            } else if (i2 == 2) {
                if (TextUtils.isEmpty(str)) {
                    str = k(R.string.share_failed, new Object[0]);
                }
                u(str);
            }
            if (!TextUtils.isEmpty(this.f17314c)) {
                b(i2, i3);
            } else if (StringUtils.isNull(this.f17315d)) {
            } else {
                b(i2, i3);
            }
        }
    }

    public void y(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, str, i2) == null) {
            BdToast.i(c(), str, i2, false).q();
        }
    }
}
