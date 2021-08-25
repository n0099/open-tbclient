package c.a.p0.d1.e;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import c.a.p0.d1.e.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e implements a.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f13102e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f13103f;

    /* renamed from: g  reason: collision with root package name */
    public int f13104g;

    /* renamed from: h  reason: collision with root package name */
    public ListView f13105h;

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
        this.f13104g = -16777216;
        this.f13105h = listView;
    }

    @Override // c.a.p0.d1.e.a.j
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            ((ImageView) view).setImageDrawable(null);
            this.f13102e.recycle();
            this.f13102e = null;
        }
    }

    @Override // c.a.p0.d1.e.a.j
    public View b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            ListView listView = this.f13105h;
            View childAt = listView.getChildAt((i2 + listView.getHeaderViewsCount()) - this.f13105h.getFirstVisiblePosition());
            if (childAt == null) {
                return null;
            }
            childAt.setPressed(false);
            childAt.setDrawingCacheEnabled(true);
            this.f13102e = Bitmap.createBitmap(childAt.getDrawingCache());
            childAt.setDrawingCacheEnabled(false);
            if (this.f13103f == null) {
                this.f13103f = new ImageView(this.f13105h.getContext());
            }
            this.f13103f.setBackgroundColor(this.f13104g);
            this.f13103f.setPadding(0, 0, 0, 0);
            this.f13103f.setImageBitmap(this.f13102e);
            this.f13103f.setLayoutParams(new ViewGroup.LayoutParams(childAt.getWidth(), childAt.getHeight()));
            return this.f13103f;
        }
        return (View) invokeI.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f13104g = i2;
        }
    }
}
