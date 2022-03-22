package c.a.p0.f1.q1;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.g;
import c.a.d.f.p.n;
import c.a.o0.r.t.j;
import c.a.p0.a4.b0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
/* loaded from: classes2.dex */
public abstract class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;

    /* renamed from: b  reason: collision with root package name */
    public final ForumWriteData f14418b;

    /* renamed from: c  reason: collision with root package name */
    public View f14419c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f14420d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f14421e;

    /* renamed from: f  reason: collision with root package name */
    public View f14422f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14423g;

    /* renamed from: h  reason: collision with root package name */
    public SerializableItemInfo f14424h;
    public final c i;
    public Gson j;
    public j k;
    public SaveDraftDialogView l;

    /* renamed from: c.a.p0.f1.q1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1087a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1087a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.obfuscated_res_0x7f091bec) {
                this.a.b();
                this.a.a.finish();
            } else if (id == R.id.obfuscated_res_0x7f091bed) {
                this.a.k();
                this.a.a.finish();
            }
            this.a.k.dismiss();
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, forumWriteData, serializableItemInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new Gson();
        this.a = baseFragmentActivity;
        this.f14418b = forumWriteData;
        this.f14424h = serializableItemInfo;
        this.i = new c(baseFragmentActivity, baseFragmentActivity.getUniqueId(), this.f14418b, this.f14424h);
        f();
        e();
        g();
    }

    public void b() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (forumWriteData = this.f14418b) == null) {
            return;
        }
        b0.B(String.valueOf(forumWriteData.forumId), null);
    }

    public abstract void c();

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14419c : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f14420d == null) {
            return;
        }
        TextView textView = new TextView(this.a);
        this.f14423g = textView;
        textView.setAlpha(0.5f);
        this.f14423g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f10e1));
        this.f14423g.setTextSize(0, n.f(this.a, R.dimen.tbds44));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = n.f(this.a, R.dimen.tbds44);
        this.f14423g.setLayoutParams(layoutParams);
        this.f14420d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f14423g, this);
        TextView centerTextTitle = this.f14420d.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f0ef1));
        this.f14421e = centerTextTitle;
        centerTextTitle.setTextSize(0, n.f(this.a, R.dimen.tbds44));
        this.f14422f = this.f14420d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public abstract void f();

    public abstract void g();

    public void h(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) {
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setBackgroundColor(this.f14419c, R.color.CAM_X0201);
            TextView textView = this.f14421e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            }
            TextView textView2 = this.f14423g;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0304);
            }
            NavigationBar navigationBar = this.f14420d;
            if (navigationBar != null) {
                navigationBar.onBackBtnOnChangeSkin();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            g.a(this.k, this.a);
        }
    }

    public abstract void k();

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.l == null) {
                this.l = new SaveDraftDialogView(this.a);
                this.l.setOnClickListener(new View$OnClickListenerC1087a(this));
            }
            if (this.k == null) {
                j jVar = new j(this.a.getPageContext());
                this.k = jVar;
                jVar.setContentView(this.l);
            }
            this.l.setText(this.a.getString(R.string.obfuscated_res_0x7f0f1589), null, this.a.getString(R.string.obfuscated_res_0x7f0f105d));
            this.k.m();
        }
    }
}
