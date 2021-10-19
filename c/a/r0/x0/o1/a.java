package c.a.r0.x0.o1;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.g;
import c.a.e.e.p.l;
import c.a.r0.k3.z;
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
    public final BaseFragmentActivity f27528e;

    /* renamed from: f  reason: collision with root package name */
    public final ForumWriteData f27529f;

    /* renamed from: g  reason: collision with root package name */
    public View f27530g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f27531h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f27532i;

    /* renamed from: j  reason: collision with root package name */
    public View f27533j;
    public TextView k;
    public SerializableItemInfo l;
    public final c m;
    public Gson n;
    public PopupDialog o;
    public SaveDraftDialogView p;

    /* renamed from: c.a.r0.x0.o1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1290a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f27534e;

        public View$OnClickListenerC1290a(a aVar) {
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
            this.f27534e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.save_draft_dialog_not_save) {
                this.f27534e.b();
                this.f27534e.f27528e.finish();
            } else if (id == R.id.save_draft_dialog_save) {
                this.f27534e.k();
                this.f27534e.f27528e.finish();
            }
            this.f27534e.o.dismiss();
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
        this.f27528e = baseFragmentActivity;
        this.f27529f = forumWriteData;
        this.l = serializableItemInfo;
        this.m = new c(baseFragmentActivity, baseFragmentActivity.getUniqueId(), this.f27529f, this.l);
        f();
        e();
        g();
    }

    public void b() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (forumWriteData = this.f27529f) == null) {
            return;
        }
        z.v(String.valueOf(forumWriteData.forumId), null);
    }

    public abstract void c();

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f27530g : (View) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f27531h == null) {
            return;
        }
        TextView textView = new TextView(this.f27528e);
        this.k = textView;
        textView.setAlpha(0.5f);
        this.k.setText(this.f27528e.getString(R.string.send_post));
        this.k.setTextSize(0, l.g(this.f27528e, R.dimen.tbds44));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.g(this.f27528e, R.dimen.tbds44);
        this.k.setLayoutParams(layoutParams);
        this.f27531h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.k, this);
        TextView centerTextTitle = this.f27531h.setCenterTextTitle(this.f27528e.getString(R.string.publish_comment));
        this.f27532i = centerTextTitle;
        centerTextTitle.setTextSize(0, l.g(this.f27528e, R.dimen.tbds44));
        this.f27533j = this.f27531h.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
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
            SkinManager.setBackgroundColor(this.f27530g, R.color.CAM_X0201);
            TextView textView = this.f27532i;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            }
            TextView textView2 = this.k;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0304);
            }
            NavigationBar navigationBar = this.f27531h;
            if (navigationBar != null) {
                navigationBar.onBackBtnOnChangeSkin();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            g.a(this.o, this.f27528e);
        }
    }

    public abstract void k();

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.p == null) {
                this.p = new SaveDraftDialogView(this.f27528e);
                this.p.setOnClickListener(new View$OnClickListenerC1290a(this));
            }
            if (this.o == null) {
                PopupDialog popupDialog = new PopupDialog(this.f27528e.getPageContext());
                this.o = popupDialog;
                popupDialog.setContentView(this.p);
            }
            this.p.setText(this.f27528e.getString(R.string.write_save_draft_dialog_normal_title), null, this.f27528e.getString(R.string.save));
            this.o.showDialog();
        }
    }
}
