package c.a.r0.n1.l;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewStub;
import c.a.e.e.p.l;
import c.a.q0.d1.e;
import c.a.q0.d1.m0;
import c.a.r0.z2.o;
import c.a.r0.z2.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.MultiImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f22486f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f22487g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f22488a;

    /* renamed from: b  reason: collision with root package name */
    public int f22489b;

    /* renamed from: c  reason: collision with root package name */
    public o f22490c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.z2.e0.a f22491d;

    /* renamed from: e  reason: collision with root package name */
    public MultiImageView f22492e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-914968994, "Lc/a/r0/n1/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-914968994, "Lc/a/r0/n1/l/a;");
                return;
            }
        }
        f22486f = l.g(TbadkApplication.getInst(), R.dimen.tbds44);
        f22487g = l.k(TbadkApplication.getInst()) - (f22486f * 2);
    }

    public a(ViewStub viewStub, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        try {
            this.f22491d = (c.a.r0.z2.e0.a) y.o().k(IAdBaseAsyncController.Type.PIC_BANNER, null);
        } catch (ClassCastException unused) {
        }
        this.f22490c = this.f22491d.i(viewStub, tbPageContext);
    }

    public final e a(int i2, boolean z, boolean z2, String str, int i3, String str2, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), str, Integer.valueOf(i3), str2, str3, str4})) == null) {
            e eVar = new e();
            eVar.f12937j = z;
            if (z) {
                return eVar;
            }
            eVar.f12930c = i2;
            eVar.f12931d = z2 ? this.f22489b : this.f22488a;
            MultiImageView multiImageView = this.f22492e;
            if (multiImageView != null && multiImageView.getCurrentUrlDragImageView() != null && this.f22492e.getCurrentUrlDragImageView().getImageView() != null) {
                float[] resizedSize = this.f22492e.getCurrentUrlDragImageView().getImageView().getResizedSize();
                if (resizedSize.length == 2) {
                    float f2 = resizedSize[0];
                    float f3 = resizedSize[1];
                    eVar.f12932e = f3;
                    if (f3 != 0.0f) {
                        eVar.f12933f = f2 / f3;
                    }
                }
                eVar.f12935h = l.g(TbadkApplication.getInst(), R.dimen.tbds130);
                ImageUrlData imageUrlData = this.f22492e.getCurrentUrlDragImageView().getImageView().getImageUrlData();
                JSONArray jSONArray = null;
                if (imageUrlData != null) {
                    try {
                        if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                            jSONArray = new JSONArray(imageUrlData.richTextArray);
                        }
                    } catch (JSONException unused) {
                    }
                }
                if (jSONArray != null) {
                    eVar.f12935h += f22486f * Math.min(((Integer) m0.i(TbRichTextView.parse((Context) TbadkCoreApplication.getInst(), jSONArray, false).toString(), l.g(TbadkApplication.getInst(), R.dimen.tbds42), f22487g).second).intValue(), 3);
                }
                if (imageUrlData != null) {
                    eVar.k = imageUrlData.isBlockedPic;
                }
            }
            eVar.f12934g = str;
            eVar.f12936i = i3;
            eVar.l = str2;
            eVar.m = str3;
            return eVar;
        }
        return (e) invokeCommon.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f22491d.onDestroy();
            this.f22490c.onDestroy();
        }
    }

    public void c(MultiImageView multiImageView, boolean z, int i2, boolean z2, String str, int i3, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{multiImageView, Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), str, Integer.valueOf(i3), str2, str3, str4}) == null) {
            this.f22492e = multiImageView;
            e a2 = a(i2, z2, z, str, i3, str2, str3, str4);
            d(this.f22491d.c(a2), a2, z);
        }
    }

    public final void d(AdvertAppInfo advertAppInfo, e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, advertAppInfo, eVar, z) == null) {
            this.f22490c.a(advertAppInfo, eVar);
            if (advertAppInfo != null) {
                if (z) {
                    this.f22489b = Math.max(this.f22489b, eVar.f12930c);
                } else {
                    this.f22488a = Math.max(this.f22488a, eVar.f12930c);
                }
            }
        }
    }
}
