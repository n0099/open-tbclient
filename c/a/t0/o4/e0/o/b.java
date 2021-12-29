package c.a.t0.o4.e0.o;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import c.a.s0.e1.o0;
import c.a.t0.o4.g;
import c.a.t0.o4.h;
import c.a.t0.o4.j;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.vote.WriteVoteActivity;
import com.baidu.tieba.write.write.vote.WriteVoteViewAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements c.a.s0.y0.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public Intent E;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<WriteVoteActivity> f21685e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21686f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f21687g;

    /* renamed from: h  reason: collision with root package name */
    public BdRecyclerView f21688h;

    /* renamed from: i  reason: collision with root package name */
    public WriteVoteViewAdapter f21689i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f21690j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f21691k;
    public TextView l;
    public EditText m;
    public List<WriteVoteItemData> n;
    public WriteVoteData o;
    public ForumWriteData p;
    public String q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public TextView z;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21692e;

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
            this.f21692e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n.K(this.f21692e.f21685e.getPageActivity(), this.f21692e.m);
            }
        }
    }

    /* renamed from: c.a.t0.o4.e0.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1309b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21693e;

        public C1309b(b bVar) {
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
            this.f21693e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                this.f21693e.m.setTypeface(Typeface.defaultFromStyle(0));
                this.f21693e.C = false;
                this.f21693e.H(false);
                return;
            }
            String replace = obj.replace(" ", "");
            if (o0.d(replace) > 40) {
                this.f21693e.f21685e.showToast(String.format(this.f21693e.f21685e.getString(j.write_vote_toast), 20));
            }
            String m = o0.m(replace, 40);
            if (!m.equals(editable.toString())) {
                this.f21693e.m.setText(m);
                this.f21693e.m.setSelection(m.length());
            }
            this.f21693e.m.setTypeface(Typeface.defaultFromStyle(1));
            this.f21693e.C = true;
            b bVar = this.f21693e;
            bVar.H(bVar.D);
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
    public class c implements WriteVoteViewAdapter.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21694e;

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
                this.f21694e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f21694e.a.f21689i.setData(this.f21694e.a.n);
                }
            }
        }

        /* renamed from: c.a.t0.o4.e0.o.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1310b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21695e;

            public RunnableC1310b(c cVar) {
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
                this.f21695e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f21695e.a.f21689i.setData(this.f21695e.a.n);
                }
            }
        }

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
            this.a = bVar;
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.n.remove(i2);
                this.a.f21688h.post(new RunnableC1310b(this));
                b bVar = this.a;
                bVar.D = bVar.w();
                b bVar2 = this.a;
                bVar2.H(bVar2.C && this.a.D);
            }
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.n.add(new WriteVoteItemData());
                this.a.f21688h.post(new a(this));
                b bVar = this.a;
                bVar.D = bVar.w();
                b bVar2 = this.a;
                bVar2.H(bVar2.C && this.a.D);
            }
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void c(WriteVoteItemData writeVoteItemData, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, writeVoteItemData, i2) == null) {
                this.a.n.set(i2, writeVoteItemData);
                b bVar = this.a;
                bVar.D = bVar.w();
                b bVar2 = this.a;
                bVar2.H(bVar2.C && this.a.D);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1 || i2 == 2) {
                    n.w(this.a.f21685e.getPageActivity(), recyclerView);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21696e;

        public e(b bVar) {
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
            this.f21696e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                List<WriteVoteItemData> v = this.f21696e.v();
                HashMap hashMap = new HashMap();
                int size = v.size();
                for (int i2 = 0; i2 < size; i2++) {
                    WriteVoteItemData writeVoteItemData = v.get(i2);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        this.f21696e.f21685e.showToast(String.format(this.f21696e.f21685e.getString(j.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i2 + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i2));
                }
                this.f21696e.o = new WriteVoteData();
                this.f21696e.o.setTitle(this.f21696e.m.getText().toString());
                this.f21696e.o.setExpire_type(this.f21696e.B);
                this.f21696e.o.setIs_multi(this.f21696e.A);
                this.f21696e.o.setOptions(v);
                this.f21696e.E = new Intent();
                this.f21696e.E.putExtra(IntentConfig.WRITE_VOTE_DATA, this.f21696e.o);
                this.f21696e.f21685e.getPageActivity().finish();
                b bVar = this.f21696e;
                bVar.D(bVar.q);
            }
        }
    }

    public b(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A = 0;
        this.B = -1;
        this.C = false;
        this.D = false;
        this.f21685e = tbPageContext;
        this.f21686f = linearLayout;
        this.f21687g = navigationBar;
        Intent intent = tbPageContext.getPageActivity().getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("extra_data");
            if (serializableExtra instanceof WriteVoteData) {
                this.o = (WriteVoteData) serializableExtra;
            } else if (serializableExtra instanceof ForumWriteData) {
                this.p = (ForumWriteData) serializableExtra;
            }
            this.q = intent.getStringExtra("title");
        }
        WriteVoteData writeVoteData = this.o;
        if (writeVoteData != null && !ListUtils.isEmpty(writeVoteData.getOptions()) && this.o.getOptions().size() >= 2) {
            this.n = this.o.getOptions();
        } else {
            ArrayList arrayList = new ArrayList();
            this.n = arrayList;
            arrayList.add(new WriteVoteItemData());
            this.n.add(new WriteVoteItemData());
        }
        x();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.s.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.v.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.x.setOnClickListener(this);
            this.y.setOnClickListener(this);
            this.m.addTextChangedListener(new C1309b(this));
            this.f21689i.setOnVoteItemListener(new c(this));
            this.f21688h.addOnScrollListener(new d(this));
            this.z.setOnClickListener(new e(this));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21687g.setCenterTextTitle(this.f21685e.getResources().getString(j.write_add_vote));
            TextView addTextButton = this.f21687g.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f21685e.getResources().getString(j.done));
            this.z = addTextButton;
            addTextButton.setTextSize(0, n.f(this.f21685e.getPageActivity(), c.a.t0.o4.e.tbds44));
            this.z.setEnabled(false);
        }
    }

    public final void C() {
        WriteVoteData writeVoteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (writeVoteData = this.o) == null) {
            return;
        }
        this.m.setText(writeVoteData.getTitle());
        this.A = this.o.getIs_multi();
        this.B = this.o.getExpire_type();
        G();
        F();
        boolean w = w();
        this.D = w;
        H(this.C && w);
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.p == null || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.f21685e.getPageActivity()).setType(9).setForumWriteData(this.p).setShowVoteData(this.o).setTitle(str).send();
    }

    public final void E(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, textView, z) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.f21685e.getResources().getDimension(c.a.t0.o4.e.tbds10));
            if (z) {
                SkinManager.setViewTextColor(textView, c.a.t0.o4.d.CAM_X0302);
                gradientDrawable.setColor(SkinManager.getColor(c.a.t0.o4.d.CAM_X0905));
                textView.setBackgroundDrawable(gradientDrawable);
                return;
            }
            SkinManager.setViewTextColor(textView, c.a.t0.o4.d.CAM_X0105);
            gradientDrawable.setColor(SkinManager.getColor(c.a.t0.o4.d.CAM_X0209));
            textView.setBackgroundDrawable(gradientDrawable);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            E(this.v, this.B == -1);
            E(this.w, this.B == 1);
            E(this.x, this.B == 7);
            E(this.y, this.B == 30);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            E(this.s, this.A != 1);
            E(this.t, this.A == 1);
        }
    }

    public final void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.z.setEnabled(z);
            if (z) {
                this.z.setTextColor(SkinManager.getColor(c.a.t0.o4.d.CAM_X0302));
            } else {
                this.z.setTextColor(c.a.t0.w3.c.a(SkinManager.getColor(c.a.t0.o4.d.CAM_X0302), 0.5f));
            }
        }
    }

    @Override // c.a.s0.y0.b
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.E : (Intent) invokeV.objValue;
    }

    @Override // c.a.s0.y0.b
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.s0.y0.b
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            LinearLayout linearLayout = this.f21690j;
            return linearLayout != null && this.f21688h != null && linearLayout.getTop() == 0 && this.f21688h.getFirstVisiblePosition() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            if (view.getId() == g.vote_type_single) {
                this.A = 0;
                G();
            } else if (view.getId() == g.vote_type_multiple) {
                this.A = 1;
                G();
            } else if (view.getId() == g.vote_time_forever) {
                this.B = -1;
                F();
            } else if (view.getId() == g.vote_time_1_day) {
                this.B = 1;
                F();
            } else if (view.getId() == g.vote_time_7_days) {
                this.B = 7;
                F();
            } else if (view.getId() == g.vote_time_30_days) {
                this.B = 30;
                F();
            }
        }
    }

    @Override // c.a.s0.y0.b
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            SkinManager.setViewTextColor(this.l, c.a.t0.o4.d.CAM_X0109);
            this.m.setHintTextColor(SkinManager.getColor(c.a.t0.o4.d.CAM_X0109));
            this.m.setTextColor(SkinManager.getColor(c.a.t0.o4.d.CAM_X0105));
            this.r.setTextColor(SkinManager.getColor(c.a.t0.o4.d.CAM_X0105));
            this.u.setTextColor(SkinManager.getColor(c.a.t0.o4.d.CAM_X0105));
            if (this.C && this.D) {
                this.z.setTextColor(SkinManager.getColor(c.a.t0.o4.d.CAM_X0302));
            } else {
                this.z.setTextColor(c.a.t0.w3.c.a(SkinManager.getColor(c.a.t0.o4.d.CAM_X0302), 0.5f));
            }
            G();
            F();
            WriteVoteViewAdapter writeVoteViewAdapter = this.f21689i;
            if (writeVoteViewAdapter != null) {
                writeVoteViewAdapter.notifyDataSetChanged();
            }
        }
    }

    public final List<WriteVoteItemData> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<WriteVoteItemData> list = this.n;
            if (list == null) {
                return arrayList;
            }
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
                int i3 = i2 + 1;
                writeVoteItemData.setId(i3);
                writeVoteItemData.setText(this.n.get(i2).getText());
                arrayList.add(writeVoteItemData);
                i2 = i3;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int size = this.n.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (StringUtils.isNull(this.n.get(i2).getText())) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            BdRecyclerView bdRecyclerView = new BdRecyclerView(this.f21685e.getPageActivity());
            this.f21688h = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.f21685e.getPageActivity()));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = n.f(this.f21685e.getPageActivity(), c.a.t0.o4.e.tbds27);
            this.f21686f.addView(this.f21688h, layoutParams);
            WriteVoteViewAdapter writeVoteViewAdapter = new WriteVoteViewAdapter(this.f21685e);
            this.f21689i = writeVoteViewAdapter;
            this.f21688h.setAdapter(writeVoteViewAdapter);
            B();
            z();
            y();
            A();
            this.f21688h.addHeaderView(this.f21690j);
            this.f21688h.addFooterView(this.f21691k);
            this.f21689i.setData(this.n);
            C();
            this.m.requestFocus();
            this.m.postDelayed(new a(this), 150L);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f21685e.getPageActivity()).inflate(h.view_vote_footer, (ViewGroup) null);
            this.f21691k = linearLayout;
            this.r = (TextView) linearLayout.findViewById(g.write_vote_type);
            this.s = (TextView) this.f21691k.findViewById(g.vote_type_single);
            this.t = (TextView) this.f21691k.findViewById(g.vote_type_multiple);
            this.u = (TextView) this.f21691k.findViewById(g.write_vote_time);
            this.v = (TextView) this.f21691k.findViewById(g.vote_time_forever);
            this.w = (TextView) this.f21691k.findViewById(g.vote_time_1_day);
            this.x = (TextView) this.f21691k.findViewById(g.vote_time_7_days);
            this.y = (TextView) this.f21691k.findViewById(g.vote_time_30_days);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f21685e.getPageActivity()).inflate(h.view_vote_header, (ViewGroup) null);
            this.f21690j = linearLayout;
            this.l = (TextView) linearLayout.findViewById(g.vote_item_tip);
            this.m = (EditText) this.f21690j.findViewById(g.vote_title);
        }
    }
}
