package c.a.r0.q4.u.o;

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
import c.a.q0.c1.o0;
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
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public class b implements c.a.q0.x0.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public Intent E;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<WriteVoteActivity> f21491e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f21492f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f21493g;

    /* renamed from: h  reason: collision with root package name */
    public BdRecyclerView f21494h;

    /* renamed from: i  reason: collision with root package name */
    public WriteVoteViewAdapter f21495i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f21496j;
    public LinearLayout k;
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

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21497e;

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
            this.f21497e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n.L(this.f21497e.f21491e.getPageActivity(), this.f21497e.m);
            }
        }
    }

    /* renamed from: c.a.r0.q4.u.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1348b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21498e;

        public C1348b(b bVar) {
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
            this.f21498e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                this.f21498e.m.setTypeface(Typeface.defaultFromStyle(0));
                this.f21498e.C = false;
                this.f21498e.H(false);
                return;
            }
            String replace = obj.replace(" ", "");
            if (o0.d(replace) > 40) {
                this.f21498e.f21491e.showToast(String.format(this.f21498e.f21491e.getString(R.string.write_vote_toast), 20));
            }
            String n = o0.n(replace, 40);
            if (!n.equals(editable.toString())) {
                this.f21498e.m.setText(n);
                this.f21498e.m.setSelection(n.length());
            }
            this.f21498e.m.setTypeface(Typeface.defaultFromStyle(1));
            this.f21498e.C = true;
            b bVar = this.f21498e;
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

    /* loaded from: classes2.dex */
    public class c implements WriteVoteViewAdapter.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21499e;

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
                this.f21499e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f21499e.a.f21495i.setData(this.f21499e.a.n);
                }
            }
        }

        /* renamed from: c.a.r0.q4.u.o.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1349b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f21500e;

            public RunnableC1349b(c cVar) {
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
                this.f21500e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f21500e.a.f21495i.setData(this.f21500e.a.n);
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
                this.a.f21494h.post(new RunnableC1349b(this));
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
                this.a.f21494h.post(new a(this));
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

    /* loaded from: classes2.dex */
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
                    n.w(this.a.f21491e.getPageActivity(), recyclerView);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f21501e;

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
            this.f21501e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                List<WriteVoteItemData> v = this.f21501e.v();
                HashMap hashMap = new HashMap();
                int size = v.size();
                for (int i2 = 0; i2 < size; i2++) {
                    WriteVoteItemData writeVoteItemData = v.get(i2);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        this.f21501e.f21491e.showToast(String.format(this.f21501e.f21491e.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i2 + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i2));
                }
                this.f21501e.o = new WriteVoteData();
                this.f21501e.o.setTitle(this.f21501e.m.getText().toString());
                this.f21501e.o.setExpire_type(this.f21501e.B);
                this.f21501e.o.setIs_multi(this.f21501e.A);
                this.f21501e.o.setOptions(v);
                this.f21501e.E = new Intent();
                this.f21501e.E.putExtra(IntentConfig.WRITE_VOTE_DATA, this.f21501e.o);
                this.f21501e.f21491e.getPageActivity().finish();
                b bVar = this.f21501e;
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
        this.f21491e = tbPageContext;
        this.f21492f = linearLayout;
        this.f21493g = navigationBar;
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
            this.m.addTextChangedListener(new C1348b(this));
            this.f21495i.setOnVoteItemListener(new c(this));
            this.f21494h.addOnScrollListener(new d(this));
            this.z.setOnClickListener(new e(this));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f21493g.setCenterTextTitle(this.f21491e.getResources().getString(R.string.write_add_vote));
            TextView addTextButton = this.f21493g.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f21491e.getResources().getString(R.string.done));
            this.z = addTextButton;
            addTextButton.setTextSize(0, n.f(this.f21491e.getPageActivity(), R.dimen.tbds44));
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
        WriteActivityConfig.newInstance(this.f21491e.getPageActivity()).setType(9).setForumWriteData(this.p).setShowVoteData(this.o).setTitle(str).send();
    }

    public final void E(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, textView, z) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.f21491e.getResources().getDimension(R.dimen.tbds10));
            if (z) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
                gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0905));
                textView.setBackgroundDrawable(gradientDrawable);
                return;
            }
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0209));
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
                this.z.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            } else {
                this.z.setTextColor(c.a.r0.y3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
            }
        }
    }

    @Override // c.a.q0.x0.b
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.E : (Intent) invokeV.objValue;
    }

    @Override // c.a.q0.x0.b
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.x0.b
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            LinearLayout linearLayout = this.f21496j;
            return linearLayout != null && this.f21494h != null && linearLayout.getTop() == 0 && this.f21494h.getFirstVisiblePosition() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            if (view.getId() == R.id.vote_type_single) {
                this.A = 0;
                G();
            } else if (view.getId() == R.id.vote_type_multiple) {
                this.A = 1;
                G();
            } else if (view.getId() == R.id.vote_time_forever) {
                this.B = -1;
                F();
            } else if (view.getId() == R.id.vote_time_1_day) {
                this.B = 1;
                F();
            } else if (view.getId() == R.id.vote_time_7_days) {
                this.B = 7;
                F();
            } else if (view.getId() == R.id.vote_time_30_days) {
                this.B = 30;
                F();
            }
        }
    }

    @Override // c.a.q0.x0.b
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            this.m.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.u.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (this.C && this.D) {
                this.z.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            } else {
                this.z.setTextColor(c.a.r0.y3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
            }
            G();
            F();
            WriteVoteViewAdapter writeVoteViewAdapter = this.f21495i;
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
            BdRecyclerView bdRecyclerView = new BdRecyclerView(this.f21491e.getPageActivity());
            this.f21494h = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.f21491e.getPageActivity()));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = n.f(this.f21491e.getPageActivity(), R.dimen.tbds27);
            this.f21492f.addView(this.f21494h, layoutParams);
            WriteVoteViewAdapter writeVoteViewAdapter = new WriteVoteViewAdapter(this.f21491e);
            this.f21495i = writeVoteViewAdapter;
            this.f21494h.setAdapter(writeVoteViewAdapter);
            B();
            z();
            y();
            A();
            this.f21494h.addHeaderView(this.f21496j);
            this.f21494h.addFooterView(this.k);
            this.f21495i.setData(this.n);
            C();
            this.m.requestFocus();
            this.m.postDelayed(new a(this), 150L);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f21491e.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
            this.k = linearLayout;
            this.r = (TextView) linearLayout.findViewById(R.id.write_vote_type);
            this.s = (TextView) this.k.findViewById(R.id.vote_type_single);
            this.t = (TextView) this.k.findViewById(R.id.vote_type_multiple);
            this.u = (TextView) this.k.findViewById(R.id.write_vote_time);
            this.v = (TextView) this.k.findViewById(R.id.vote_time_forever);
            this.w = (TextView) this.k.findViewById(R.id.vote_time_1_day);
            this.x = (TextView) this.k.findViewById(R.id.vote_time_7_days);
            this.y = (TextView) this.k.findViewById(R.id.vote_time_30_days);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f21491e.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
            this.f21496j = linearLayout;
            this.l = (TextView) linearLayout.findViewById(R.id.vote_item_tip);
            this.m = (EditText) this.f21496j.findViewById(R.id.vote_title);
        }
    }
}
