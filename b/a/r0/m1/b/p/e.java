package b.a.r0.m1.b.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.a.f;
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
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f22286a;

    /* renamed from: b  reason: collision with root package name */
    public View f22287b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f22288c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22289d;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f22290e;

    /* renamed from: f  reason: collision with root package name */
    public b f22291f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f22292g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f22293e;

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
            this.f22293e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f22293e.f22290e.getId()) {
                    b.a.q0.t.h.a.c(this.f22293e.f22286a);
                    TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 1));
                } else if (view.getId() == this.f22293e.f22288c.getId()) {
                    b.a.q0.s.e0.b.j().w("key_im_open_notification_close_time", System.currentTimeMillis());
                    if (this.f22293e.f22291f != null) {
                        this.f22293e.f22291f.onClose();
                    }
                    TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 2));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
        this.f22292g = new a(this);
        this.f22286a = fVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.open_notification_view, (ViewGroup) null);
        this.f22287b = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_close);
        this.f22288c = imageView;
        imageView.setOnClickListener(this.f22292g);
        this.f22289d = (TextView) this.f22287b.findViewById(R.id.open_desc);
        this.f22290e = (TBSpecificationBtn) this.f22287b.findViewById(R.id.btn_open);
        this.f22290e.setConfig(new b.a.q0.s.g0.n.b());
        this.f22290e.setText(fVar.getString(R.string.go_to_open));
        this.f22290e.setOnClickListener(this.f22292g);
        TiebaStatic.log("c13704");
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f22287b : (View) invokeV.objValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f22287b, R.color.CAM_X0206);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f22288c, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.f22289d, R.color.CAM_X0107);
        }
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f22291f = bVar;
        }
    }
}
