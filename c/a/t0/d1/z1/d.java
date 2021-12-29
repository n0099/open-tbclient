package c.a.t0.d1.z1;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.e1;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.i1;
import c.a.t0.d1.z1.c;
import c.a.t0.w3.a0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.SearchMajorActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.HeadItem;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public class d extends c.a.t0.d1.z1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText A;
    public ImageView B;
    public View C;
    public View D;
    public RankStarView E;
    public RankStarView F;
    public Editable G;
    public Editable H;
    public TextView I;
    public TextView J;
    public TbImageView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public EditText z;

    /* loaded from: classes7.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f17343e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17343e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent == null || motionEvent.getAction() != 2) {
                    return false;
                }
                n.w(this.f17343e.f17324e, view);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.t0.d1.z1.c.b
        public void a(InputMethodManager inputMethodManager) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, inputMethodManager) == null) || inputMethodManager == null) {
                return;
            }
            d dVar = this.a;
            dVar.f17324e.HidenSoftKeyPad(inputMethodManager, dVar.z);
            d dVar2 = this.a;
            dVar2.f17324e.HidenSoftKeyPad(inputMethodManager, dVar2.A);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f17344e;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17344e = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f17344e.G = editable;
                if (this.f17344e.G.length() <= 500) {
                    this.f17344e.I.setVisibility(4);
                } else {
                    this.f17344e.I.setText((500 - this.f17344e.G.length()) + "/500");
                    this.f17344e.I.setVisibility(0);
                }
                this.f17344e.A();
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

    /* renamed from: c.a.t0.d1.z1.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1058d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f17345e;

        public C1058d(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17345e = dVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f17345e.H = editable;
                if (this.f17345e.H.length() <= 500) {
                    this.f17345e.J.setVisibility(4);
                } else {
                    this.f17345e.J.setText((500 - this.f17345e.H.length()) + "/500");
                    this.f17345e.J.setVisibility(0);
                }
                this.f17345e.A();
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
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f17346e;

        public e(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17346e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view.getId() == f1.university_comment) {
                    d dVar = this.f17346e;
                    if (dVar.z(dVar.z)) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        if (motionEvent.getAction() == 1) {
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f17347e;

        public f(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17347e = dVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (view.getId() == f1.university_subject_comment) {
                    d dVar = this.f17347e;
                    if (dVar.z(dVar.A)) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        if (motionEvent.getAction() == 1) {
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                        }
                    }
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements a0.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f17348e;

        public g(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17348e = dVar;
        }

        @Override // c.a.t0.w3.a0.e
        public void onDraftLoaded(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) || writeData == null) {
                return;
            }
            try {
                this.f17348e.F.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
            } catch (NumberFormatException unused) {
                this.f17348e.F.setStarCount(0.0f);
            }
            try {
                this.f17348e.E.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
            } catch (NumberFormatException unused2) {
                this.f17348e.E.setStarCount(0.0f);
            }
            this.f17348e.v.setText(writeData.getmUniversitySubjectContent());
            this.f17348e.z.setText(writeData.getmUniversityComment());
            this.f17348e.A.setText(writeData.getmUniversitySubjectComment());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, forumWriteData, serializableItemInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragmentActivity) objArr2[0], (ForumWriteData) objArr2[1], (SerializableItemInfo) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TextUtils.isEmpty(this.G) && this.G.length() >= 20 && !TextUtils.isEmpty(this.H) && this.H.length() >= 20 && !this.f17324e.getString(i1.select_subject).equals(this.v.getText()) && this.G.length() <= 500 && this.H.length() <= 500) {
                this.f17330k.setAlpha(1.0f);
            } else {
                this.f17330k.setAlpha(0.5f);
            }
        }
    }

    public final String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            int starCount = this.F.getStarCount();
            int starCount2 = this.E.getStarCount();
            if (starCount != 0) {
                arrayList.add(new HeadItem("学校评分", String.valueOf(starCount2), 2));
            }
            arrayList.add(new HeadItem("专业", this.v.getText().toString(), 1));
            if (starCount2 != 0) {
                arrayList.add(new HeadItem("专业评分", String.valueOf(starCount), 2));
            }
            return this.n.toJson(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public final String C(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (list != null) {
                StringBuilder sb = new StringBuilder();
                for (String str : list) {
                    sb.append(str);
                    sb.append(" ");
                }
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // c.a.t0.d1.z1.a
    public void c() {
        ForumWriteData forumWriteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (forumWriteData = this.f17325f) == null) {
            return;
        }
        a0.p(String.valueOf(forumWriteData.forumId), new g(this));
    }

    @Override // c.a.t0.d1.z1.a
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = LayoutInflater.from(this.f17324e).inflate(g1.activity_university_evaluation, (ViewGroup) null);
            this.f17326g = inflate;
            this.f17327h = (NavigationBar) inflate.findViewById(f1.navigation_bar);
            this.q = (TbImageView) this.f17326g.findViewById(f1.university_icon);
            this.r = (TextView) this.f17326g.findViewById(f1.university_name);
            this.s = (TextView) this.f17326g.findViewById(f1.university_desc);
            this.t = (TextView) this.f17326g.findViewById(f1.university_grade);
            this.u = (TextView) this.f17326g.findViewById(f1.university_subject);
            this.v = (TextView) this.f17326g.findViewById(f1.university_subject_content);
            this.B = (ImageView) this.f17326g.findViewById(f1.subject_right_arrow);
            this.w = (TextView) this.f17326g.findViewById(f1.university_subject_grade);
            this.x = (TextView) this.f17326g.findViewById(f1.university_comment_title);
            this.y = (TextView) this.f17326g.findViewById(f1.subject_comment_title);
            EditText editText = (EditText) this.f17326g.findViewById(f1.university_comment);
            this.z = editText;
            editText.setLineSpacing(n.f(this.f17324e, d1.tbds16), 1.0f);
            EditText editText2 = (EditText) this.f17326g.findViewById(f1.university_subject_comment);
            this.A = editText2;
            editText2.setLineSpacing(n.f(this.f17324e, d1.tbds16), 1.0f);
            this.I = (TextView) this.f17326g.findViewById(f1.university_comment_counter);
            this.J = (TextView) this.f17326g.findViewById(f1.university_subject_comment_counter);
            this.D = this.f17326g.findViewById(f1.select_subject_layout);
            RankStarView rankStarView = (RankStarView) this.f17326g.findViewById(f1.university_grade_star);
            this.E = rankStarView;
            rankStarView.setClickable(true);
            this.E.setStarSpacing(n.f(this.f17324e, d1.tbds24));
            RankStarView rankStarView2 = (RankStarView) this.f17326g.findViewById(f1.university_subject_grade_star);
            this.F = rankStarView2;
            rankStarView2.setClickable(true);
            this.F.setStarSpacing(n.f(this.f17324e, d1.tbds24));
            this.C = this.f17326g.findViewById(f1.divider);
            SerializableItemInfo serializableItemInfo = this.l;
            if (serializableItemInfo != null) {
                this.s.setText(C(serializableItemInfo.getTags()));
                this.r.setText(this.l.getName());
                this.q.startLoad(this.l.icon_url, 10, false);
            }
            this.q.setPlaceHolder(2);
            this.q.setPageId(this.f17324e.getUniqueId());
            this.q.setConrers(15);
            this.q.setRadius(n.f(this.f17324e, d1.tbds10));
            this.f17326g.findViewById(f1.scroll_view).setOnTouchListener(new a(this));
            this.m.h(new b(this));
        }
    }

    @Override // c.a.t0.d1.z1.a
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f17329j.setOnClickListener(this);
            this.f17330k.setOnClickListener(this);
            this.D.setOnClickListener(this);
            this.z.addTextChangedListener(new c(this));
            this.A.addTextChangedListener(new C1058d(this));
            this.z.setOnTouchListener(new e(this));
            this.A.setOnTouchListener(new f(this));
        }
    }

    @Override // c.a.t0.d1.z1.a
    public void h(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) && i3 == -1 && intent != null && i2 == 25047) {
            String stringExtra = intent.getStringExtra(IntentConfig.SEARCH_MAJOR_NAME);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            this.v.setText(stringExtra);
            SkinManager.setViewTextColor(this.v, c1.CAM_X0105);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.B, e1.icon_pure_list_arrow16_right_svg, c1.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            A();
        }
    }

    @Override // c.a.t0.d1.z1.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.i();
            SkinManager.setBackgroundColor(this.C, c1.CAM_X0204);
            SkinManager.setViewTextColor(this.r, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.s, c1.CAM_X0109);
            SkinManager.setViewTextColor(this.t, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.u, c1.CAM_X0105);
            if (this.f17324e.getString(i1.select_subject).equals(this.v.getText())) {
                SkinManager.setViewTextColor(this.v, c1.CAM_X0109);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.B, e1.icon_pure_list_arrow16_right_svg, c1.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SkinManager.setViewTextColor(this.v, c1.CAM_X0105);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.B, e1.icon_pure_list_arrow16_right_svg, c1.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            SkinManager.setViewTextColor(this.w, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.x, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.y, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.z, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.A, c1.CAM_X0105);
            SkinManager.setViewTextColor(this.I, c1.CAM_X0301);
            SkinManager.setViewTextColor(this.J, c1.CAM_X0301);
            this.z.setHintTextColor(SkinManager.getColor(c1.CAM_X0109));
            this.A.setHintTextColor(SkinManager.getColor(c1.CAM_X0109));
            TbImageView tbImageView = this.q;
            if (tbImageView != null) {
                tbImageView.setPlaceHolder(2);
                this.q.invalidate();
            }
        }
    }

    @Override // c.a.t0.d1.z1.a
    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f17325f == null) {
            return;
        }
        WriteData writeData = new WriteData();
        int starCount = this.F.getStarCount();
        writeData.setmUniversityGrade(String.valueOf(this.E.getStarCount()));
        writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
        writeData.setmUniversitySubjectContent(this.v.getText().toString());
        writeData.setmUniversityComment(this.z.getText().toString());
        writeData.setmUniversitySubjectComment(this.A.getText().toString());
        a0.y(String.valueOf(this.f17325f.forumId), writeData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            if (view == this.f17329j) {
                l();
            } else if (view == this.D) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchMajorActivityConfig(this.f17324e, 25047)));
            } else if (view == this.f17330k) {
                if (!TextUtils.isEmpty(this.G) && !TextUtils.isEmpty(this.H) && !this.f17324e.getString(i1.select_subject).equals(this.v.getText())) {
                    if (this.G.length() < 20) {
                        n.L(this.f17324e, i1.university_comment_size_error_tip);
                        return;
                    } else if (this.H.length() < 20) {
                        n.L(this.f17324e, i1.subject_comment_size_error_tip);
                        return;
                    } else if (this.G.length() > 500) {
                        n.L(this.f17324e, i1.university_comment_lenght_error_tip);
                        return;
                    } else if (this.H.length() > 500) {
                        n.L(this.f17324e, i1.subject_comment_lenght_error_tip);
                        return;
                    } else {
                        this.m.g("学校评价：" + ((Object) this.G) + StringUtils.LF + "专业评价：" + ((Object) this.H), B(), this.f17325f);
                        return;
                    }
                }
                n.L(this.f17324e, i1.university_comment_must_write_tip);
            }
        }
    }

    public final boolean z(EditText editText) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, editText)) == null) {
            int scrollY = editText.getScrollY();
            int height = editText.getLayout().getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom());
            if (height == 0) {
                return false;
            }
            return scrollY > 0 || scrollY < height - 1;
        }
        return invokeL.booleanValue;
    }
}
