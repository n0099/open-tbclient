package c.a.t0.e1.a2;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.g;
import c.a.d.f.p.n;
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.f1;
import c.a.t0.e1.i1;
import c.a.t0.x3.a0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
/* loaded from: classes7.dex */
public abstract class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final BaseFragmentActivity f15993e;

    /* renamed from: f  reason: collision with root package name */
    public final ForumWriteData f15994f;

    /* renamed from: g  reason: collision with root package name */
    public View f15995g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f15996h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f15997i;

    /* renamed from: j  reason: collision with root package name */
    public View f15998j;
    public TextView k;
    public SerializableItemInfo l;
    public final c m;
    public Gson n;
    public PopupDialog o;
    public SaveDraftDialogView p;

    /* renamed from: c.a.t0.e1.a2.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1018a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15999e;

        public View$OnClickListenerC1018a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15999e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            int id = view.getId();
            if (id == f1.save_draft_dialog_not_save) {
                this.f15999e.b();
                this.f15999e.f15993e.finish();
            } else if (id == f1.save_draft_dialog_save) {
                this.f15999e.k();
                this.f15999e.f15993e.finish();
            }
            this.f15999e.o.dismiss();
        }
    }

    public a(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, forumWriteData, serializableItemInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new Gson();
        this.f15993e = baseFragmentActivity;
        this.f15994f = forumWriteData;
        this.l = serializableItemInfo;
        this.m = new c(baseFragmentActivity, baseFragmentActivity.getUniqueId(), this.f15994f, this.l);
        f();
        e();
        g();
    }

    public void b() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (forumWriteData = this.f15994f) == null) {
            return;
        }
        a0.B(String.valueOf(forumWriteData.forumId), null);
    }

    public abstract void c();

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15995g : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f15996h == null) {
            return;
        }
        TextView textView = new TextView(this.f15993e);
        this.k = textView;
        textView.setAlpha(0.5f);
        this.k.setText(this.f15993e.getString(i1.send_post));
        this.k.setTextSize(0, n.f(this.f15993e, d1.tbds44));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = n.f(this.f15993e, d1.tbds44);
        this.k.setLayoutParams(layoutParams);
        this.f15996h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.k, this);
        TextView centerTextTitle = this.f15996h.setCenterTextTitle(this.f15993e.getString(i1.publish_comment));
        this.f15997i = centerTextTitle;
        centerTextTitle.setTextSize(0, n.f(this.f15993e, d1.tbds44));
        this.f15998j = this.f15996h.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
    }

    public abstract void f();

    public abstract void g();

    public void h(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) {
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setBackgroundColor(this.f15995g, c1.CAM_X0201);
            TextView textView = this.f15997i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, c1.CAM_X0105);
            }
            TextView textView2 = this.k;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, c1.CAM_X0304);
            }
            NavigationBar navigationBar = this.f15996h;
            if (navigationBar != null) {
                navigationBar.onBackBtnOnChangeSkin();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            g.a(this.o, this.f15993e);
        }
    }

    public abstract void k();

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.p == null) {
                this.p = new SaveDraftDialogView(this.f15993e);
                this.p.setOnClickListener(new View$OnClickListenerC1018a(this));
            }
            if (this.o == null) {
                PopupDialog popupDialog = new PopupDialog(this.f15993e.getPageContext());
                this.o = popupDialog;
                popupDialog.setContentView(this.p);
            }
            this.p.setText(this.f15993e.getString(i1.write_save_draft_dialog_normal_title), null, this.f15993e.getString(i1.save));
            this.o.showDialog();
        }
    }
}
