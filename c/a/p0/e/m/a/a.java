package c.a.p0.e.m.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.h;
import c.a.p0.a.p.d.h0;
import c.a.p0.a.s1.f;
import c.a.p0.a.v2.u;
import c.a.p0.a.z1.b.f.e;
import c.a.p0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.facade.picture.wallpaper.PictureWallpaperActivity;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes.dex */
public class a implements h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.e.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0513a extends BaseBitmapDataSubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f10411a;

        public C0513a(a aVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10411a = context;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                e.f(this.f10411a, h.swan_app_img_menu_save_failed).u();
            }
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                a.i(this.f10411a, bitmap);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f10412a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f10413b;

        public b(Context context, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, bitmap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10412a = context;
            this.f10413b = bitmap;
        }

        @Override // c.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                a.l(this.f10412a, this.f10413b);
            }
        }

        @Override // c.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                e.f(this.f10412a, h.swan_app_img_menu_save_failed).u();
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void i(Context context, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, bitmap) == null) {
            c.a.p0.a.s1.e.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new b(context, bitmap));
        }
    }

    public static boolean k(@NonNull Context context, @NonNull Bitmap bitmap, @NonNull String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, bitmap, str)) == null) {
            String p = d.p(str);
            if (bitmap.hasAlpha() && !"png".equalsIgnoreCase(p)) {
                str = d.r(str) + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX;
                p = "png";
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if ("png".equalsIgnoreCase(p)) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                if (Build.VERSION.SDK_INT >= 29) {
                    return m(context, byteArrayInputStream, "image/png", str);
                }
                String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + File.separator + "Image" + File.separator + str;
                boolean p2 = u.p(bitmap, str2, 80, Bitmap.CompressFormat.PNG);
                if (p2) {
                    u.q(context, str2);
                }
                return p2;
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            if (Build.VERSION.SDK_INT >= 29) {
                return m(context, byteArrayInputStream2, "image/jpeg", str);
            }
            String str3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + File.separator + "Image" + File.separator + str;
            boolean p3 = u.p(bitmap, str3, 80, Bitmap.CompressFormat.JPEG);
            if (p3) {
                u.q(context, str3);
            }
            return p3;
        }
        return invokeLLL.booleanValue;
    }

    public static void l(Context context, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, bitmap) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.CHINA);
            if (k(context, bitmap, "IMG_" + simpleDateFormat.format(new Date()) + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX)) {
                e.f(context, h.swan_app_img_menu_save_success).u();
            } else {
                e.f(context, h.swan_app_img_menu_save_failed).u();
            }
        }
    }

    public static boolean m(@NonNull Context context, @NonNull InputStream inputStream, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, inputStream, str, str2)) != null) {
            return invokeLLLL.booleanValue;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str2);
        contentValues.put("mime_type", str);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/Image/");
        } else {
            contentValues.put("_data", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath() + "/Image");
        }
        Uri insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert == null) {
            c.a.p0.a.e0.d.l("FacadeSwanAppImageImpl", "insert uri is null");
            return false;
        }
        try {
            OutputStream openOutputStream = context.getContentResolver().openOutputStream(insert);
            if (openOutputStream == null) {
                d.d(openOutputStream);
                return false;
            }
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    openOutputStream.write(bArr, 0, read);
                } else {
                    d.d(openOutputStream);
                    return true;
                }
            }
        } catch (IOException unused) {
            d.d(null);
            return false;
        } catch (Throwable th) {
            d.d(null);
            throw th;
        }
    }

    @Override // c.a.p0.a.p.d.h0
    public void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, jSONObject) == null) {
            PictureWallpaperActivity.launchWallpaperActivity(context, jSONObject.optString("imageUrl"), jSONObject.optString("referer"));
        }
    }

    @Override // c.a.p0.a.p.d.h0
    public void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject) == null) || jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("index");
        JSONArray optJSONArray = jSONObject.optJSONArray("urls");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        int length = optJSONArray.length();
        ArrayList<MediaModel> arrayList = new ArrayList<>(length);
        for (int i2 = 0; i2 < length; i2++) {
            String optString = optJSONArray.optString(i2);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(new ImageModel(optString));
            }
        }
        j(context, arrayList, optInt);
    }

    @Override // c.a.p0.a.p.d.h0
    public void c(GenericDraweeHierarchy genericDraweeHierarchy, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, genericDraweeHierarchy, z) == null) {
        }
    }

    @Override // c.a.p0.a.p.d.h0
    public void d(Context context, String[] strArr, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048579, this, context, strArr, i2) == null) || strArr == null || strArr.length <= 0) {
            return;
        }
        ArrayList<MediaModel> arrayList = new ArrayList<>(strArr.length);
        for (String str : strArr) {
            arrayList.add(new ImageModel(str));
        }
        j(context, arrayList, i2);
    }

    @Override // c.a.p0.a.p.d.h0
    public ImageRequestBuilder e(ImageRequestBuilder imageRequestBuilder, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, imageRequestBuilder, map)) == null) ? imageRequestBuilder : (ImageRequestBuilder) invokeLL.objValue;
    }

    @Override // c.a.p0.a.p.d.h0
    public void f(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, jSONObject) == null) {
            String optString = jSONObject.optString("imageUrl");
            String optString2 = jSONObject.optString("referer");
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.parse(optString));
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(optString2)) {
                hashMap.put("referer", optString2);
            }
            c.a.p0.a.c1.a.y().e(newBuilderWithSource, hashMap);
            Fresco.getImagePipeline().fetchDecodedImage(newBuilderWithSource.build(), context).subscribe(new C0513a(this, context), UiThreadImmediateExecutorService.getInstance());
        }
    }

    public final void j(Context context, ArrayList<MediaModel> arrayList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, context, arrayList, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("mediaModels", arrayList);
            bundle.putInt("previewPosition", i2);
            bundle.putString("previewFrom", UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE);
            Intent intent = new Intent(context, SwanAppAlbumPreviewActivity.class);
            intent.putExtra("launchParams", bundle);
            context.startActivity(intent);
        }
    }
}
