package c.a.t0.x.r;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import c.a.t0.x.n;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.h;
import c.a.u0.a4.j;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f14619e;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14619e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n nVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (nVar = this.f14619e) == null) {
                return;
            }
            nVar.sendAction(new c.a.t0.x.a(14, -1, Boolean.TRUE));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public static n a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, context, i2)) == null) {
            c.a.t0.d0.b bVar = new c.a.t0.d0.b();
            MultiImgToolView multiImgToolView = (MultiImgToolView) LayoutInflater.from(context).inflate(h.editor_tool_container_image, (ViewGroup) null);
            multiImgToolView.initView();
            if (multiImgToolView == null || multiImgToolView.getDragLayer() == null || multiImgToolView.getDragHorizonScrollView() == null || multiImgToolView.getMutiImageTips() == null) {
                return null;
            }
            multiImgToolView.setAsyncLocalImageLoader(bVar);
            c.a.u0.z3.n0.a aVar = new c.a.u0.z3.n0.a(context);
            aVar.e(multiImgToolView.getDragLayer());
            aVar.g(multiImgToolView.getDragHorizonScrollView());
            aVar.f(multiImgToolView.getDragHorizonScrollView());
            if (i2 > 1) {
                multiImgToolView.getDragHorizonScrollView().setAddView(b(context, multiImgToolView));
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            }
            multiImgToolView.getDragHorizonScrollView().setOnSwapDataListener(multiImgToolView);
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i2);
            SkinManager.setViewTextColor(multiImgToolView.getMutiImageTips(), c.a.u0.a4.d.CAM_X0108, 1);
            return multiImgToolView;
        }
        return (n) invokeLI.objValue;
    }

    public static View b(Context context, n nVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, nVar)) == null) {
            ImageView imageView = new ImageView(context);
            SkinManager.setImageResource(imageView, f.btn_add_photo_selector);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setClickable(true);
            imageView.setContentDescription(context.getString(j.add));
            int d2 = c.a.d.f.p.n.d(context, 3.0f);
            imageView.setPadding(d2, context.getResources().getDimensionPixelSize(e.ds30) + d2 + c.a.d.f.p.n.d(context, 1.0f), context.getResources().getDimensionPixelSize(e.ds32) + d2, d2);
            imageView.setOnClickListener(new a(nVar));
            return imageView;
        }
        return (View) invokeLL.objValue;
    }
}
