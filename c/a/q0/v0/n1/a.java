package c.a.q0.v0.n1;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.g;
import c.a.e.e.p.l;
import c.a.q0.i3.y;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.PopupDialog;
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
/* loaded from: classes4.dex */
public abstract class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final BaseFragmentActivity f26663e;

    /* renamed from: f  reason: collision with root package name */
    public final ForumWriteData f26664f;

    /* renamed from: g  reason: collision with root package name */
    public View f26665g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f26666h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f26667i;

    /* renamed from: j  reason: collision with root package name */
    public View f26668j;
    public TextView k;
    public SerializableItemInfo l;
    public final c m;
    public Gson n;
    public PopupDialog o;
    public SaveDraftDialogView p;

    /* renamed from: c.a.q0.v0.n1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1243a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26669e;

        public View$OnClickListenerC1243a(a aVar) {
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
            this.f26669e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.save_draft_dialog_not_save) {
                this.f26669e.b();
                this.f26669e.f26663e.finish();
            } else if (id == R.id.save_draft_dialog_save) {
                this.f26669e.k();
                this.f26669e.f26663e.finish();
            }
            this.f26669e.o.dismiss();
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
        this.f26663e = baseFragmentActivity;
        this.f26664f = forumWriteData;
        this.l = serializableItemInfo;
        this.m = new c(baseFragmentActivity, baseFragmentActivity.getUniqueId(), this.f26664f, this.l);
        f();
        e();
        g();
    }

    public void b() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (forumWriteData = this.f26664f) == null) {
            return;
        }
        y.v(String.valueOf(forumWriteData.forumId), null);
    }

    public abstract void c();

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f26665g : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f26666h == null) {
            return;
        }
        TextView textView = new TextView(this.f26663e);
        this.k = textView;
        textView.setAlpha(0.5f);
        this.k.setText(this.f26663e.getString(R.string.send_post));
        this.k.setTextSize(0, l.g(this.f26663e, R.dimen.tbds44));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.g(this.f26663e, R.dimen.tbds44);
        this.k.setLayoutParams(layoutParams);
        this.f26666h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.k, this);
        TextView centerTextTitle = this.f26666h.setCenterTextTitle(this.f26663e.getString(R.string.publish_comment));
        this.f26667i = centerTextTitle;
        centerTextTitle.setTextSize(0, l.g(this.f26663e, R.dimen.tbds44));
        this.f26668j = this.f26666h.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
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
            SkinManager.setBackgroundColor(this.f26665g, R.color.CAM_X0201);
            TextView textView = this.f26667i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            TextView textView2 = this.k;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0304);
            }
            NavigationBar navigationBar = this.f26666h;
            if (navigationBar != null) {
                navigationBar.onBackBtnOnChangeSkin();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            g.a(this.o, this.f26663e);
        }
    }

    public abstract void k();

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.p == null) {
                this.p = new SaveDraftDialogView(this.f26663e);
                this.p.setOnClickListener(new View$OnClickListenerC1243a(this));
            }
            if (this.o == null) {
                PopupDialog popupDialog = new PopupDialog(this.f26663e.getPageContext());
                this.o = popupDialog;
                popupDialog.setContentView(this.p);
            }
            this.p.setText(this.f26663e.getString(R.string.write_save_draft_dialog_normal_title), null, this.f26663e.getString(R.string.save));
            this.o.showDialog();
        }
    }
}
