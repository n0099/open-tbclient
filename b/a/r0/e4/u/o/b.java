package b.a.r0.e4.u.o;

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
import b.a.e.f.p.l;
import b.a.q0.c1.m0;
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
/* loaded from: classes4.dex */
public class b implements b.a.q0.w0.a, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public Intent E;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<WriteVoteActivity> f17794e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f17795f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f17796g;

    /* renamed from: h  reason: collision with root package name */
    public BdRecyclerView f17797h;

    /* renamed from: i  reason: collision with root package name */
    public WriteVoteViewAdapter f17798i;
    public LinearLayout j;
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

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17799e;

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
            this.f17799e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.K(this.f17799e.f17794e.getPageActivity(), this.f17799e.m);
            }
        }
    }

    /* renamed from: b.a.r0.e4.u.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0896b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17800e;

        public C0896b(b bVar) {
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
            this.f17800e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                this.f17800e.m.setTypeface(Typeface.defaultFromStyle(0));
                this.f17800e.C = false;
                this.f17800e.N(false);
                return;
            }
            String replace = obj.replace(" ", "");
            if (m0.d(replace) > 40) {
                this.f17800e.f17794e.showToast(String.format(this.f17800e.f17794e.getString(R.string.write_vote_toast), 20));
            }
            String m = m0.m(replace, 40);
            if (!m.equals(editable.toString())) {
                this.f17800e.m.setText(m);
                this.f17800e.m.setSelection(m.length());
            }
            this.f17800e.m.setTypeface(Typeface.defaultFromStyle(1));
            this.f17800e.C = true;
            b bVar = this.f17800e;
            bVar.N(bVar.D);
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

    /* loaded from: classes4.dex */
    public class c implements WriteVoteViewAdapter.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17801a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f17802e;

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
                this.f17802e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17802e.f17801a.f17798i.setData(this.f17802e.f17801a.n);
                }
            }
        }

        /* renamed from: b.a.r0.e4.u.o.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0897b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f17803e;

            public RunnableC0897b(c cVar) {
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
                this.f17803e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17803e.f17801a.f17798i.setData(this.f17803e.f17801a.n);
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
            this.f17801a = bVar;
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f17801a.n.remove(i2);
                this.f17801a.f17797h.post(new RunnableC0897b(this));
                b bVar = this.f17801a;
                bVar.D = bVar.v();
                b bVar2 = this.f17801a;
                bVar2.N(bVar2.C && this.f17801a.D);
            }
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f17801a.n.add(new WriteVoteItemData());
                this.f17801a.f17797h.post(new a(this));
                b bVar = this.f17801a;
                bVar.D = bVar.v();
                b bVar2 = this.f17801a;
                bVar2.N(bVar2.C && this.f17801a.D);
            }
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void c(WriteVoteItemData writeVoteItemData, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, writeVoteItemData, i2) == null) {
                this.f17801a.n.set(i2, writeVoteItemData);
                b bVar = this.f17801a;
                bVar.D = bVar.v();
                b bVar2 = this.f17801a;
                bVar2.N(bVar2.C && this.f17801a.D);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17804a;

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
            this.f17804a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1 || i2 == 2) {
                    l.x(this.f17804a.f17794e.getPageActivity(), recyclerView);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17805e;

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
            this.f17805e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                List<WriteVoteItemData> u = this.f17805e.u();
                HashMap hashMap = new HashMap();
                int size = u.size();
                for (int i2 = 0; i2 < size; i2++) {
                    WriteVoteItemData writeVoteItemData = u.get(i2);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        this.f17805e.f17794e.showToast(String.format(this.f17805e.f17794e.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i2 + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i2));
                }
                this.f17805e.o = new WriteVoteData();
                this.f17805e.o.setTitle(this.f17805e.m.getText().toString());
                this.f17805e.o.setExpire_type(this.f17805e.B);
                this.f17805e.o.setIs_multi(this.f17805e.A);
                this.f17805e.o.setOptions(u);
                this.f17805e.E = new Intent();
                this.f17805e.E.putExtra(IntentConfig.WRITE_VOTE_DATA, this.f17805e.o);
                this.f17805e.f17794e.getPageActivity().finish();
                b bVar = this.f17805e;
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
        this.f17794e = tbPageContext;
        this.f17795f = linearLayout;
        this.f17796g = navigationBar;
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
        w();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17796g.setCenterTextTitle(this.f17794e.getResources().getString(R.string.write_add_vote));
            TextView addTextButton = this.f17796g.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f17794e.getResources().getString(R.string.done));
            this.z = addTextButton;
            addTextButton.setTextSize(0, l.g(this.f17794e.getPageActivity(), R.dimen.tbds44));
            this.z.setEnabled(false);
        }
    }

    public final void B() {
        WriteVoteData writeVoteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (writeVoteData = this.o) == null) {
            return;
        }
        this.m.setText(writeVoteData.getTitle());
        this.A = this.o.getIs_multi();
        this.B = this.o.getExpire_type();
        M();
        L();
        boolean v = v();
        this.D = v;
        N(this.C && v);
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.p == null || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.f17794e.getPageActivity()).setType(9).setForumWriteData(this.p).setShowVoteData(this.o).setTitle(str).send();
    }

    public final void K(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, textView, z) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.f17794e.getResources().getDimension(R.dimen.tbds10));
            if (z) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0302);
                gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0905));
                textView.setBackgroundDrawable(gradientDrawable);
                return;
            }
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0209));
            textView.setBackgroundDrawable(gradientDrawable);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            K(this.v, this.B == -1);
            K(this.w, this.B == 1);
            K(this.x, this.B == 7);
            K(this.y, this.B == 30);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            K(this.s, this.A != 1);
            K(this.t, this.A == 1);
        }
    }

    public final void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.z.setEnabled(z);
            if (z) {
                this.z.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            } else {
                this.z.setTextColor(b.a.r0.m3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
            }
        }
    }

    @Override // b.a.q0.w0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.E : (Intent) invokeV.objValue;
    }

    @Override // b.a.q0.w0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.q0.w0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LinearLayout linearLayout = this.j;
            return linearLayout != null && this.f17797h != null && linearLayout.getTop() == 0 && this.f17797h.getFirstVisiblePosition() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            if (view.getId() == R.id.vote_type_single) {
                this.A = 0;
                M();
            } else if (view.getId() == R.id.vote_type_multiple) {
                this.A = 1;
                M();
            } else if (view.getId() == R.id.vote_time_forever) {
                this.B = -1;
                L();
            } else if (view.getId() == R.id.vote_time_1_day) {
                this.B = 1;
                L();
            } else if (view.getId() == R.id.vote_time_7_days) {
                this.B = 7;
                L();
            } else if (view.getId() == R.id.vote_time_30_days) {
                this.B = 30;
                L();
            }
        }
    }

    @Override // b.a.q0.w0.a
    public void onViewChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109);
            this.m.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.m.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.u.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (this.C && this.D) {
                this.z.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            } else {
                this.z.setTextColor(b.a.r0.m3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
            }
            M();
            L();
            WriteVoteViewAdapter writeVoteViewAdapter = this.f17798i;
            if (writeVoteViewAdapter != null) {
                writeVoteViewAdapter.notifyDataSetChanged();
            }
        }
    }

    public final List<WriteVoteItemData> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            BdRecyclerView bdRecyclerView = new BdRecyclerView(this.f17794e.getPageActivity());
            this.f17797h = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.f17794e.getPageActivity()));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = l.g(this.f17794e.getPageActivity(), R.dimen.tbds27);
            this.f17795f.addView(this.f17797h, layoutParams);
            WriteVoteViewAdapter writeVoteViewAdapter = new WriteVoteViewAdapter(this.f17794e);
            this.f17798i = writeVoteViewAdapter;
            this.f17797h.setAdapter(writeVoteViewAdapter);
            A();
            y();
            x();
            z();
            this.f17797h.addHeaderView(this.j);
            this.f17797h.addFooterView(this.k);
            this.f17798i.setData(this.n);
            B();
            this.m.requestFocus();
            this.m.postDelayed(new a(this), 150L);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f17794e.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
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

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f17794e.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
            this.j = linearLayout;
            this.l = (TextView) linearLayout.findViewById(R.id.vote_item_tip);
            this.m = (EditText) this.j.findViewById(R.id.vote_title);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.s.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.v.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.x.setOnClickListener(this);
            this.y.setOnClickListener(this);
            this.m.addTextChangedListener(new C0896b(this));
            this.f17798i.setOnVoteItemListener(new c(this));
            this.f17797h.addOnScrollListener(new d(this));
            this.z.setOnClickListener(new e(this));
        }
    }
}
