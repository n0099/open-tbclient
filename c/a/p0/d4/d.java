package c.a.p0.d4;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import c.a.d.f.m.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class d extends Dialog implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13683b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13684c;

    /* renamed from: d  reason: collision with root package name */
    public View f13685d;

    /* renamed from: e  reason: collision with root package name */
    public View f13686e;

    /* renamed from: f  reason: collision with root package name */
    public InterestFrsData.Tag f13687f;

    /* renamed from: g  reason: collision with root package name */
    public c f13688g;

    /* renamed from: h  reason: collision with root package name */
    public GridView f13689h;
    public LinearLayout i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        d();
    }

    @Override // c.a.p0.d4.a
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.f13688g.notifyDataSetChanged();
        }
    }

    @Override // c.a.p0.d4.a
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f13688g.notifyDataSetChanged();
        }
    }

    @Override // c.a.p0.d4.a
    public void c(InterestFrsData.Tag tag) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tag) == null) {
            this.f13687f = tag;
            if (tag != null) {
                this.f13683b.setText(tag.getBname());
                this.f13684c.setText(tag.getBdesc());
                this.f13688g.a(tag.getCard_list());
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f13686e = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d060e, null);
            this.f13688g = new c(this.a);
            setCanceledOnTouchOutside(true);
            this.i = (LinearLayout) this.f13686e.findViewById(R.id.obfuscated_res_0x7f0903e5);
            GridView gridView = (GridView) this.f13686e.findViewById(R.id.obfuscated_res_0x7f0911d2);
            this.f13689h = gridView;
            gridView.setAdapter((ListAdapter) this.f13688g);
            this.f13689h.setSelector(R.color.common_color_10022);
            setContentView(this.f13686e);
            this.f13683b = (TextView) this.f13686e.findViewById(R.id.obfuscated_res_0x7f091943);
            this.f13684c = (TextView) this.f13686e.findViewById(R.id.obfuscated_res_0x7f091942);
            View findViewById = this.f13686e.findViewById(R.id.obfuscated_res_0x7f0923c8);
            this.f13685d = findViewById;
            findViewById.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0802e3));
        }
    }

    @Override // c.a.p0.d4.a
    public View getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13686e : (View) invokeV.objValue;
    }

    @Override // android.app.Dialog, c.a.p0.d4.a
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Context context = this.a;
            if (context instanceof Activity) {
                g.a(this, (Activity) context);
            } else {
                super.dismiss();
            }
        }
    }

    @Override // c.a.p0.d4.a
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.i.setOnClickListener(onClickListener);
            this.f13688g.c(onClickListener);
        }
    }
}
