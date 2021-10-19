package c.a.r0.m1.b.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f22223a;

    /* renamed from: b  reason: collision with root package name */
    public View f22224b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f22225c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22226d;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f22227e;

    /* renamed from: f  reason: collision with root package name */
    public b f22228f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f22229g;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f22230e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22230e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f22230e.f22227e.getId()) {
                    c.a.q0.t.h.a.c(this.f22230e.f22223a);
                    TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 1));
                } else if (view.getId() == this.f22230e.f22225c.getId()) {
                    c.a.q0.s.d0.b.j().w("key_im_open_notification_close_time", System.currentTimeMillis());
                    if (this.f22230e.f22228f != null) {
                        this.f22230e.f22228f.onClose();
                    }
                    TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 2));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onClose();
    }

    public e(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f22229g = new a(this);
        this.f22223a = fVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.open_notification_view, (ViewGroup) null);
        this.f22224b = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_close);
        this.f22225c = imageView;
        imageView.setOnClickListener(this.f22229g);
        this.f22226d = (TextView) this.f22224b.findViewById(R.id.open_desc);
        this.f22227e = (TBSpecificationBtn) this.f22224b.findViewById(R.id.btn_open);
        this.f22227e.setConfig(new c.a.q0.s.f0.n.b());
        this.f22227e.setText(fVar.getString(R.string.go_to_open));
        this.f22227e.setOnClickListener(this.f22229g);
        TiebaStatic.log("c13704");
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22224b : (View) invokeV.objValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f22224b, R.color.CAM_X0206);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f22225c, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.f22226d, R.color.CAM_X0107);
        }
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f22228f = bVar;
        }
    }
}
