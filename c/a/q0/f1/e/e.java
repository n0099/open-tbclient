package c.a.q0.f1.e;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import c.a.q0.f1.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e implements a.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f12052e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f12053f;

    /* renamed from: g  reason: collision with root package name */
    public int f12054g;

    /* renamed from: h  reason: collision with root package name */
    public ListView f12055h;

    public e(ListView listView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {listView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12054g = -16777216;
        this.f12055h = listView;
    }

    @Override // c.a.q0.f1.e.a.j
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            ((ImageView) view).setImageDrawable(null);
            this.f12052e.recycle();
            this.f12052e = null;
        }
    }

    @Override // c.a.q0.f1.e.a.j
    public View b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            ListView listView = this.f12055h;
            View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f12055h.getFirstVisiblePosition());
            if (childAt == null) {
                return null;
            }
            childAt.setPressed(false);
            childAt.setDrawingCacheEnabled(true);
            this.f12052e = Bitmap.createBitmap(childAt.getDrawingCache());
            childAt.setDrawingCacheEnabled(false);
            if (this.f12053f == null) {
                this.f12053f = new ImageView(this.f12055h.getContext());
            }
            this.f12053f.setBackgroundColor(this.f12054g);
            this.f12053f.setPadding(0, 0, 0, 0);
            this.f12053f.setImageBitmap(this.f12052e);
            this.f12053f.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
            return this.f12053f;
        }
        return (View) invokeI.objValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f12054g = i2;
        }
    }
}
