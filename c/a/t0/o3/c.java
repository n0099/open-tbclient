package c.a.t0.o3;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.o4.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.ShareSDKImageView;
import com.baidu.tieba.sharewrite.WriteShareActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;

    /* renamed from: b  reason: collision with root package name */
    public View f21453b;

    /* renamed from: c  reason: collision with root package name */
    public WriteData f21454c;

    /* renamed from: d  reason: collision with root package name */
    public EditText f21455d;

    /* renamed from: e  reason: collision with root package name */
    public View f21456e;

    /* renamed from: f  reason: collision with root package name */
    public View f21457f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f21458g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f21459h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f21460i;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f21461j;

    /* renamed from: k  reason: collision with root package name */
    public PostPrefixData f21462k;
    public TextView l;
    public r m;
    public ImageView n;
    public View o;
    public LinearLayout p;
    public LinearLayout q;
    public ShareSDKImageView r;
    public TextView s;
    public TextView t;
    public WriteShareActivity u;
    public c.a.s0.d0.b v;
    public boolean w;
    public int x;
    public int y;

    /* loaded from: classes7.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
                if (z) {
                    if (this.a.r.getLoadedWidth() == 0 || this.a.r.getLoadedHeight() == 0) {
                        return;
                    }
                    c cVar = this.a;
                    cVar.x = cVar.r.getLoadedWidth();
                    c cVar2 = this.a;
                    cVar2.y = cVar2.r.getLoadedHeight();
                    if (this.a.u != null) {
                        this.a.u.getWriteData().setShareSummaryImgWidth(this.a.x);
                        this.a.u.getWriteData().setShareSummaryImgHeight(this.a.y);
                        this.a.w = true;
                        this.a.A();
                        return;
                    }
                    return;
                }
                this.a.w = false;
                this.a.A();
                if (this.a.u != null) {
                    this.a.u.shareFailed(R.string.share_load_image_fail_tip);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.w = false;
                this.a.A();
                if (this.a.u != null) {
                    this.a.u.shareFailed(R.string.share_load_image_fail_tip);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.s0.c0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21463e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21463e = cVar;
        }

        @Override // c.a.s0.c0.b
        public void imageLoaded(c.a.d.n.d.a aVar, String str, boolean z) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) || (tbImageView = (TbImageView) this.f21463e.p.findViewWithTag(str)) == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* renamed from: c.a.t0.o3.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1294c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21464e;

        public View$OnClickListenerC1294c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21464e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21464e.l.setVisibility(0);
                this.f21464e.o.setSelected(true);
                c.a.d.f.m.g.l(this.f21464e.m, view, n.d(this.f21464e.u.getPageContext().getContext(), 15.0f), n.d(this.f21464e.u.getPageContext().getContext(), 1.0f));
                if (this.f21464e.u != null) {
                    this.f21464e.u.hidenSoftKeyPad();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21465e;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21465e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21465e.l.setSelected(true);
                c.a.d.f.m.g.l(this.f21465e.m, view, n.d(this.f21465e.u.getPageContext().getContext(), 15.0f), n.d(this.f21465e.u.getPageContext().getContext(), 1.0f));
                if (this.f21465e.u != null) {
                    this.f21465e.u.hidenSoftKeyPad();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements r.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21466e;

        public e(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21466e = cVar;
        }

        @Override // c.a.t0.o4.r.a
        public void onPrefixItemClick(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f21466e.u.setCurrentPrefixPosition(i2);
                this.f21466e.l.setText(this.f21466e.f21462k.getPrefixs().get(i2));
                this.f21466e.m.c(i2);
                this.f21466e.A();
                c.a.d.f.m.g.d(this.f21466e.m, this.f21466e.u.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21467e;

        public f(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21467e = cVar;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21467e.o.setSelected(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21468e;

        public g(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21468e = cVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f21468e.A();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f21469e;

        public i(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21469e = cVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f21469e.A();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    public c(WriteShareActivity writeShareActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {writeShareActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f21453b = null;
        this.f21454c = null;
        this.f21455d = null;
        this.f21456e = null;
        this.f21458g = null;
        this.f21459h = null;
        this.f21460i = null;
        this.f21461j = null;
        this.w = false;
        this.x = 0;
        this.y = 0;
        this.u = writeShareActivity;
        this.f21454c = writeShareActivity.getWriteData();
        if (this.v == null) {
            this.v = new c.a.s0.d0.b();
        }
        w();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            String str = "1";
            if (this.f21454c.getType() == 3) {
                String trim = this.f21455d.getText().toString().trim();
                PostPrefixData postPrefixData = this.f21462k;
                if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                    if (this.u.getCurrentPrefixPosition() == this.f21462k.getPrefixs().size() - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.f21454c.setIsNoTitle(true);
                        } else {
                            this.f21454c.setIsNoTitle(false);
                        }
                    } else {
                        this.f21454c.setIsNoTitle(false);
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.f21454c.setIsNoTitle(true);
                } else {
                    this.f21454c.setIsNoTitle(false);
                }
                if (str == null && str.length() > 0 && this.w) {
                    this.f21460i.setEnabled(true);
                    return;
                } else {
                    this.f21460i.setEnabled(false);
                }
            }
            str = null;
            if (str == null) {
            }
            this.f21460i.setEnabled(false);
        }
    }

    public void B(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onFocusChangeListener) == null) {
            this.f21455d.setOnFocusChangeListener(onFocusChangeListener);
            this.f21459h.setOnFocusChangeListener(onFocusChangeListener);
            this.f21453b.setOnFocusChangeListener(onFocusChangeListener);
            this.f21460i.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f21453b.setOnClickListener(onClickListener);
        }
    }

    public void D(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f21460i.setOnClickListener(onClickListener);
        }
    }

    public void E(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.f21458g.setOnClickListener(onClickListener);
        }
    }

    public void F(PostPrefixData postPrefixData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, postPrefixData) == null) {
            this.f21462k = postPrefixData;
            u();
        }
    }

    public final void m(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, editText, i2) == null) {
            Editable text = editText.getText();
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            editText.setText((CharSequence) null);
            editText.setHintTextColor(i2);
            editText.setText(text);
            editText.setSelection(selectionStart, selectionEnd);
        }
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f21453b : (View) invokeV.objValue;
    }

    public TextView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f21460i : (TextView) invokeV.objValue;
    }

    public EditText p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f21459h : (EditText) invokeV.objValue;
    }

    public EditText q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f21455d : (EditText) invokeV.objValue;
    }

    public TextView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public r s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : (r) invokeV.objValue;
    }

    public ShareSDKImageView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.r : (ShareSDKImageView) invokeV.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.o = this.u.findViewById(R.id.post_prefix_layout);
            this.l = (TextView) this.u.findViewById(R.id.post_prefix);
            this.n = (ImageView) this.u.findViewById(R.id.prefix_icon);
            PostPrefixData postPrefixData = this.f21462k;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                this.o.setVisibility(0);
                ArrayList<String> prefixs = this.f21462k.getPrefixs();
                int size = prefixs.size();
                this.l.setText(prefixs.get(0));
                this.u.setCurrentPrefixPosition(0);
                this.o.setOnClickListener(new View$OnClickListenerC1294c(this));
                ImageView imageView = (ImageView) this.u.findViewById(R.id.prefix_icon);
                this.n = imageView;
                if (size > 1) {
                    imageView.setVisibility(0);
                    this.l.setOnClickListener(new d(this));
                }
                r rVar = new r(this.u.getPageContext().getContext());
                this.m = rVar;
                rVar.d(n.d(this.u.getPageContext().getContext(), 225.0f));
                this.m.setOutsideTouchable(true);
                this.m.setFocusable(true);
                this.m.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0204));
                this.m.e(new e(this));
                this.m.setOnDismissListener(new f(this));
                int color = SkinManager.getColor(R.color.common_color_10097);
                SkinManager.setBackgroundResource(this.l, R.drawable.write_prefix_item_selector);
                SkinManager.setImageResource(this.n, R.drawable.icon_title_down);
                this.l.setTextColor(color);
                for (int i2 = 0; i2 < size; i2++) {
                    TextView textView = new TextView(this.u.getPageContext().getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, n.d(this.u.getPageContext().getContext(), 45.0f));
                    textView.setLayoutParams(layoutParams);
                    textView.setText(prefixs.get(i2));
                    textView.setGravity(19);
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                    textView.setTextSize(1, 16.0f);
                    textView.setTextColor(color);
                    SkinManager.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                    textView.setPadding(n.d(this.u.getPageContext().getContext(), this.u.getResources().getDimension(R.dimen.ds6)), 0, n.d(this.u.getPageContext().getContext(), this.u.getResources().getDimension(R.dimen.ds22)), 0);
                    this.m.a(textView);
                    if (i2 != size - 1) {
                        layoutParams.bottomMargin = n.d(this.u.getPageContext().getContext(), 1.0f);
                        textView.setGravity(19);
                        textView.setPadding(n.d(this.u.getPageContext().getContext(), this.u.getResources().getDimension(R.dimen.ds6)), 0, n.d(this.u.getPageContext().getContext(), this.u.getResources().getDimension(R.dimen.ds22)), 0);
                    }
                }
                this.m.c(0);
                return;
            }
            this.o.setVisibility(8);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.p = (LinearLayout) this.u.findViewById(R.id.post_share_layout);
            ShareSDKImageView shareSDKImageView = (ShareSDKImageView) this.u.findViewById(R.id.post_share_image);
            this.r = shareSDKImageView;
            shareSDKImageView.setIsRound(false);
            this.r.setDrawBorder(false);
            this.r.setAutoChangeStyle(true);
            this.r.setRadius(0);
            this.s = (TextView) this.u.findViewById(R.id.post_share_title);
            this.t = (TextView) this.u.findViewById(R.id.post_share_content);
            WriteData writeData = this.f21454c;
            if (writeData != null) {
                if (writeData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                    this.r.setEvent(new a(this));
                }
                if (this.f21454c.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                    if (this.f21454c.getShareSummaryImg() != null && this.f21454c.getShareSummaryImg().trim().length() > 0) {
                        this.r.startLoad(this.f21454c.getShareSummaryImg(), 10, true);
                    } else {
                        this.w = true;
                        A();
                    }
                } else {
                    Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.f21454c.getShareLocalImageData());
                    if (Bytes2Bitmap != null) {
                        this.r.setImageBitmap(Bytes2Bitmap);
                    } else {
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        if (!TextUtils.isEmpty(this.f21454c.getShareLocalImageUri())) {
                            imageFileInfo.setFilePath(FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.f21454c.getShareLocalImageUri())));
                        }
                        imageFileInfo.clearAllActions();
                        imageFileInfo.addPersistAction(c.a.s0.d0.i.d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
                        this.r.setTag(imageFileInfo.toCachedKey(true));
                        if (this.v.d(imageFileInfo, new b(this), true) != null) {
                            this.r.invalidate();
                        }
                    }
                    this.w = true;
                    A();
                }
                WriteData writeData2 = this.f21454c;
                writeData2.setShareSummaryImgType(c.a.d.f.p.h.r(writeData2.getShareSummaryImg()));
                this.s.setText(this.f21454c.getShareSummaryTitle());
                this.t.setText(this.f21454c.getShareSummaryContent());
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.u.findViewById(R.id.view_navigation_bar);
            this.a = navigationBar;
            this.f21453b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.a.setTitleText(this.u.getPageContext().getString(R.string.share_navigationbar_title));
            this.f21460i = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.u.getPageContext().getString(R.string.send_post));
            this.f21461j = (RelativeLayout) this.u.findViewById(R.id.parent);
            this.f21456e = this.u.findViewById(R.id.interval_view);
            this.f21457f = this.u.findViewById(R.id.prefix_interval_view);
            this.p = (LinearLayout) this.u.findViewById(R.id.post_share_layout);
            this.q = (LinearLayout) this.u.findViewById(R.id.post_share_content_layout);
            this.r = (ShareSDKImageView) this.u.findViewById(R.id.post_share_image);
            this.s = (TextView) this.u.findViewById(R.id.post_share_title);
            this.t = (TextView) this.u.findViewById(R.id.post_share_content);
            y();
            x();
            LinearLayout linearLayout = (LinearLayout) this.u.findViewById(R.id.post_content_container);
            this.f21458g = linearLayout;
            linearLayout.setDrawingCacheEnabled(false);
            this.f21455d.setVisibility(0);
            this.f21459h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            A();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            EditText editText = (EditText) this.u.findViewById(R.id.post_content);
            this.f21459h = editText;
            editText.setDrawingCacheEnabled(false);
            if (this.f21454c.getContent() != null && this.f21454c.getContent().length() > 0) {
                SpannableString j2 = TbFaceManager.e().j(this.u.getPageContext().getContext(), this.f21454c.getContent());
                this.f21459h.setText(j2);
                this.f21459h.setSelection(j2.length());
            }
            this.f21459h.setOnTouchListener(new h(this));
            this.f21459h.addTextChangedListener(new i(this));
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f21455d = (EditText) this.u.findViewById(R.id.post_title);
            if (this.f21454c.getType() == 3) {
                if (this.f21454c.getTitle() != null && this.f21454c.getTitle().trim().length() > 0) {
                    this.f21455d.setText(this.f21454c.getTitle());
                    this.f21455d.setSelection(this.f21454c.getTitle().length());
                } else {
                    String str = this.u.getPageContext().getString(R.string.share_transfer_thread) + this.f21454c.getShareSummaryTitle();
                    this.f21455d.setText(str);
                    if (str.length() < 20) {
                        this.f21455d.setSelection(str.length());
                    } else {
                        this.f21455d.setSelection(20);
                    }
                }
            }
            this.f21455d.addTextChangedListener(new g(this));
        }
    }

    public void z(int i2) {
        WriteShareActivity writeShareActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (writeShareActivity = this.u) == null) {
            return;
        }
        writeShareActivity.getLayoutMode().k(i2 == 1);
        this.u.getLayoutMode().j(this.f21461j);
        this.a.onChangeSkinType(this.u.getPageContext(), i2);
        SkinManager.setTopBarCommonFinishButton(this.f21460i, i2);
        SkinManager.setBackgroundColor(this.f21456e, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f21457f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f21455d, R.color.CAM_X0111);
        SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
        int color = SkinManager.getColor(R.color.CAM_X0105);
        int color2 = SkinManager.getColor(R.color.CAM_X0110);
        this.f21455d.setTextColor(color);
        this.f21459h.setTextColor(color);
        this.s.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        m(this.f21455d, color2);
        m(this.f21459h, color2);
        A();
    }
}
