package c.a.r0.d1.z1;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.f1;
import c.a.r0.d1.g1;
import c.a.r0.d1.i1;
import c.a.r0.d1.z1.c;
import c.a.r0.t3.a0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.HeadItem;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends c.a.r0.d1.z1.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView q;
    public TextView r;
    public TextView s;
    public View t;
    public RankStarView u;
    public EditText v;
    public TextView w;
    public Editable x;

    /* loaded from: classes5.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16430e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16430e = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent == null || motionEvent.getAction() != 2) {
                    return false;
                }
                l.w(this.f16430e.f16422e, view);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* renamed from: c.a.r0.d1.z1.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0988b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0988b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.r0.d1.z1.c.b
        public void a(InputMethodManager inputMethodManager) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, inputMethodManager) == null) || inputMethodManager == null) {
                return;
            }
            b bVar = this.a;
            bVar.f16422e.HidenSoftKeyPad(inputMethodManager, bVar.v);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16431e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16431e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f16431e.x = editable;
                if (this.f16431e.x.length() > 500) {
                    this.f16431e.w.setText(String.format(this.f16431e.f16422e.getResources().getString(i1.frs_item_word_conter), Integer.valueOf(500 - this.f16431e.x.length())));
                    this.f16431e.w.setVisibility(0);
                } else {
                    this.f16431e.w.setVisibility(8);
                }
                this.f16431e.s();
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

    /* loaded from: classes5.dex */
    public class d implements a0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f16432e;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16432e = bVar;
        }

        @Override // c.a.r0.t3.a0.e
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || writeData == null) {
                return;
            }
            this.f16432e.u.setStarCount(writeData.getOtherGrade());
            this.f16432e.v.setText(writeData.getOtherComment());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1465440186, "Lc/a/r0/d1/z1/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1465440186, "Lc/a/r0/d1/z1/b;");
                return;
            }
        }
        y = l.f(TbadkCoreApplication.getInst().getContext(), d1.tbds156);
        z = l.f(TbadkCoreApplication.getInst().getContext(), d1.tbds156);
        A = l.f(TbadkCoreApplication.getInst().getContext(), d1.tbds234);
        B = l.f(TbadkCoreApplication.getInst().getContext(), d1.tbds156);
        C = l.f(TbadkCoreApplication.getInst().getContext(), d1.tbds156);
        D = l.f(TbadkCoreApplication.getInst().getContext(), d1.tbds208);
        E = l.f(TbadkCoreApplication.getInst().getContext(), d1.tbds32);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, forumWriteData, serializableItemInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragmentActivity) objArr2[0], (ForumWriteData) objArr2[1], (SerializableItemInfo) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.d1.z1.a
    public void c() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (forumWriteData = this.f16423f) == null) {
            return;
        }
        a0.n(String.valueOf(forumWriteData.forumId), new d(this));
    }

    @Override // c.a.r0.d1.z1.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.f16422e).inflate(g1.activity_other_evaluation, (ViewGroup) null);
            this.f16424g = inflate;
            this.f16425h = (NavigationBar) inflate.findViewById(f1.navigation_bar);
            this.q = (TbImageView) this.f16424g.findViewById(f1.item_icon);
            this.r = (TextView) this.f16424g.findViewById(f1.item_title);
            this.s = (TextView) this.f16424g.findViewById(f1.item_tag);
            this.t = this.f16424g.findViewById(f1.divider);
            this.u = (RankStarView) this.f16424g.findViewById(f1.item_star);
            this.v = (EditText) this.f16424g.findViewById(f1.other_comment);
            this.w = (TextView) this.f16424g.findViewById(f1.word_counter);
            this.q.setPlaceHolder(2);
            this.q.setConrers(15);
            this.q.setRadius(l.f(this.f16422e, d1.tbds10));
            this.u.setStarSpacing(l.f(this.f16422e, d1.tbds24));
            this.u.setClickable(true);
            this.v.setLineSpacing(l.f(this.f16422e, d1.tbds16), 1.0f);
            SerializableItemInfo serializableItemInfo = this.l;
            if (serializableItemInfo != null) {
                u(serializableItemInfo.getTags());
                this.r.setText(this.l.getName());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                if (this.l.getIconSize() == 1.0d) {
                    layoutParams.width = y;
                    layoutParams.height = z;
                } else if (this.l.getIconSize() == 0.67d) {
                    layoutParams.width = A;
                    layoutParams.height = B;
                } else {
                    layoutParams.width = C;
                    layoutParams.height = D;
                }
                this.q.setLayoutParams(layoutParams);
                this.q.startLoad(this.l.icon_url, 10, false);
                if (this.l.getScore() != null && this.l.getScore().isCommented == 1) {
                    this.u.setStarCount(this.l.getScore().getCommentStar());
                }
            }
            this.f16424g.findViewById(f1.scroll_view).setOnTouchListener(new a(this));
            this.m.h(new C0988b(this));
        }
    }

    @Override // c.a.r0.d1.z1.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16427j.setOnClickListener(this);
            this.f16428k.setOnClickListener(this);
            this.v.addTextChangedListener(new c(this));
        }
    }

    @Override // c.a.r0.d1.z1.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.i();
            SkinManager.setBackgroundColor(this.t, c1.CAM_X0204);
            SkinManager.setViewTextColor(this.r, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.s, c1.CAM_X0109);
            this.u.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            SkinManager.setViewTextColor(this.v, c1.CAM_X0105);
            this.v.setHintTextColor(SkinManager.getColor(c1.CAM_X0109));
            SkinManager.setViewTextColor(this.w, c1.CAM_X0301);
            TbImageView tbImageView = this.q;
            if (tbImageView != null) {
                tbImageView.setPlaceHolder(2);
                this.q.invalidate();
            }
        }
    }

    @Override // c.a.r0.d1.z1.a
    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f16423f == null) {
            return;
        }
        WriteData writeData = new WriteData();
        writeData.setOtherGrade(this.u.getStarCount());
        writeData.setOtherComment(this.v.getText().toString());
        a0.v(String.valueOf(this.f16423f.forumId), writeData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view == this.f16427j) {
                l();
            } else if (view == this.f16428k) {
                if (!TextUtils.isEmpty(this.x) && this.x.length() >= 20) {
                    if (this.x.length() > 500) {
                        l.L(this.f16422e, i1.other_comment_size_long_tip);
                        return;
                    } else {
                        this.m.g(this.x.toString(), t(), this.f16423f);
                        return;
                    }
                }
                l.L(this.f16422e, i1.other_comment_size_short_tip);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!TextUtils.isEmpty(this.x) && this.x.length() >= 20 && this.x.length() <= 500) {
                this.f16428k.setAlpha(1.0f);
            } else {
                this.f16428k.setAlpha(0.5f);
            }
        }
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new HeadItem("", String.valueOf(this.u.getStarCount()), 2));
            return this.n.toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public final void u(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                this.s.setVisibility(0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    spannableStringBuilder.append((CharSequence) list.get(i2));
                    if (i2 != list.size() - 1) {
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                        spannableStringBuilder2.setSpan(new c.a.q0.s.g0.r.b(E), 0, spannableStringBuilder2.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                    }
                }
                this.s.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
                return;
            }
            this.s.setVisibility(8);
        }
    }
}
