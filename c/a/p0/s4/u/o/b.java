package c.a.p0.s4.u.o;

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
import c.a.o0.c1.o0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
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
public class b implements c.a.o0.x0.b, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Intent A;
    public TbPageContext<WriteVoteActivity> a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f18541b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f18542c;

    /* renamed from: d  reason: collision with root package name */
    public BdRecyclerView f18543d;

    /* renamed from: e  reason: collision with root package name */
    public WriteVoteViewAdapter f18544e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f18545f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f18546g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f18547h;
    public EditText i;
    public List<WriteVoteItemData> j;
    public WriteVoteData k;
    public ForumWriteData l;
    public String m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n.L(this.a.a.getPageActivity(), this.a.i);
            }
        }
    }

    /* renamed from: c.a.p0.s4.u.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1401b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C1401b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                this.a.i.setTypeface(Typeface.defaultFromStyle(0));
                this.a.y = false;
                this.a.H(false);
                return;
            }
            String replace = obj.replace(" ", "");
            if (o0.d(replace) > 40) {
                this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f159e), 20));
            }
            String n = o0.n(replace, 40);
            if (!n.equals(editable.toString())) {
                this.a.i.setText(n);
                this.a.i.setSelection(n.length());
            }
            this.a.i.setTypeface(Typeface.defaultFromStyle(1));
            this.a.y = true;
            b bVar = this.a;
            bVar.H(bVar.z);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
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
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.f18544e.setData(this.a.a.j);
                }
            }
        }

        /* renamed from: c.a.p0.s4.u.o.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1402b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public RunnableC1402b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.f18544e.setData(this.a.a.j);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.j.remove(i);
                this.a.f18543d.post(new RunnableC1402b(this));
                b bVar = this.a;
                bVar.z = bVar.w();
                b bVar2 = this.a;
                bVar2.H(bVar2.y && this.a.z);
            }
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.j.add(new WriteVoteItemData());
                this.a.f18543d.post(new a(this));
                b bVar = this.a;
                bVar.z = bVar.w();
                b bVar2 = this.a;
                bVar2.H(bVar2.y && this.a.z);
            }
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void c(WriteVoteItemData writeVoteItemData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, writeVoteItemData, i) == null) {
                this.a.j.set(i, writeVoteItemData);
                b bVar = this.a;
                bVar.z = bVar.w();
                b bVar2 = this.a;
                bVar2.H(bVar2.y && this.a.z);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    n.w(this.a.a.getPageActivity(), recyclerView);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public e(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                List<WriteVoteItemData> u = this.a.u();
                HashMap hashMap = new HashMap();
                int size = u.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = u.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f159c), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                this.a.k = new WriteVoteData();
                this.a.k.setTitle(this.a.i.getText().toString());
                this.a.k.setExpire_type(this.a.x);
                this.a.k.setIs_multi(this.a.w);
                this.a.k.setOptions(u);
                this.a.A = new Intent();
                this.a.A.putExtra(IntentConfig.WRITE_VOTE_DATA, this.a.k);
                this.a.a.getPageActivity().finish();
                b bVar = this.a;
                bVar.D(bVar.m);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = 0;
        this.x = -1;
        this.y = false;
        this.z = false;
        this.a = tbPageContext;
        this.f18541b = linearLayout;
        this.f18542c = navigationBar;
        Intent intent = tbPageContext.getPageActivity().getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVoteActivityConfig.EXTRA_DATA_KEY);
            if (serializableExtra instanceof WriteVoteData) {
                this.k = (WriteVoteData) serializableExtra;
            } else if (serializableExtra instanceof ForumWriteData) {
                this.l = (ForumWriteData) serializableExtra;
            }
            this.m = intent.getStringExtra("title");
        }
        WriteVoteData writeVoteData = this.k;
        if (writeVoteData != null && !ListUtils.isEmpty(writeVoteData.getOptions()) && this.k.getOptions().size() >= 2) {
            this.j = this.k.getOptions();
        } else {
            ArrayList arrayList = new ArrayList();
            this.j = arrayList;
            arrayList.add(new WriteVoteItemData());
            this.j.add(new WriteVoteItemData());
        }
        x();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.i.addTextChangedListener(new C1401b(this));
            this.f18544e.h(new c(this));
            this.f18543d.addOnScrollListener(new d(this));
            this.v.setOnClickListener(new e(this));
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f18542c.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1576));
            TextView addTextButton = this.f18542c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f04e0));
            this.v = addTextButton;
            addTextButton.setTextSize(0, n.f(this.a.getPageActivity(), R.dimen.tbds44));
            this.v.setEnabled(false);
        }
    }

    public final void C() {
        WriteVoteData writeVoteData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (writeVoteData = this.k) == null) {
            return;
        }
        this.i.setText(writeVoteData.getTitle());
        this.w = this.k.getIs_multi();
        this.x = this.k.getExpire_type();
        G();
        F();
        boolean w = w();
        this.z = w;
        H(this.y && w);
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.l == null || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(this.l).setShowVoteData(this.k).setTitle(str).send();
    }

    public final void E(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, textView, z) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.a.getResources().getDimension(R.dimen.tbds10));
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
            E(this.r, this.x == -1);
            E(this.s, this.x == 1);
            E(this.t, this.x == 7);
            E(this.u, this.x == 30);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            E(this.o, this.w != 1);
            E(this.p, this.w == 1);
        }
    }

    public final void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.v.setEnabled(z);
            if (z) {
                this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            } else {
                this.v.setTextColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
            }
        }
    }

    @Override // c.a.o0.x0.b
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.A : (Intent) invokeV.objValue;
    }

    @Override // c.a.o0.x0.b
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.o0.x0.b
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            LinearLayout linearLayout = this.f18545f;
            return linearLayout != null && this.f18543d != null && linearLayout.getTop() == 0 && this.f18543d.getFirstVisiblePosition() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view) == null) {
            if (view.getId() == R.id.obfuscated_res_0x7f092436) {
                this.w = 0;
                G();
            } else if (view.getId() == R.id.obfuscated_res_0x7f092435) {
                this.w = 1;
                G();
            } else if (view.getId() == R.id.obfuscated_res_0x7f092432) {
                this.x = -1;
                F();
            } else if (view.getId() == R.id.obfuscated_res_0x7f09242f) {
                this.x = 1;
                F();
            } else if (view.getId() == R.id.obfuscated_res_0x7f092431) {
                this.x = 7;
                F();
            } else if (view.getId() == R.id.obfuscated_res_0x7f092430) {
                this.x = 30;
                F();
            }
        }
    }

    @Override // c.a.o0.x0.b
    public void onViewChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            SkinManager.setViewTextColor(this.f18547h, (int) R.color.CAM_X0109);
            this.i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.n.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (this.y && this.z) {
                this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            } else {
                this.v.setTextColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
            }
            G();
            F();
            WriteVoteViewAdapter writeVoteViewAdapter = this.f18544e;
            if (writeVoteViewAdapter != null) {
                writeVoteViewAdapter.notifyDataSetChanged();
            }
        }
    }

    public final List<WriteVoteItemData> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<WriteVoteItemData> list = this.j;
            if (list == null) {
                return arrayList;
            }
            int size = list.size();
            int i = 0;
            while (i < size) {
                WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
                int i2 = i + 1;
                writeVoteItemData.setId(i2);
                writeVoteItemData.setText(this.j.get(i).getText());
                arrayList.add(writeVoteItemData);
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                if (StringUtils.isNull(this.j.get(i).getText())) {
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
            BdRecyclerView bdRecyclerView = new BdRecyclerView(this.a.getPageActivity());
            this.f18543d = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = n.f(this.a.getPageActivity(), R.dimen.tbds27);
            this.f18541b.addView(this.f18543d, layoutParams);
            WriteVoteViewAdapter writeVoteViewAdapter = new WriteVoteViewAdapter(this.a);
            this.f18544e = writeVoteViewAdapter;
            this.f18543d.setAdapter(writeVoteViewAdapter);
            B();
            z();
            y();
            A();
            this.f18543d.s(this.f18545f);
            this.f18543d.r(this.f18546g);
            this.f18544e.setData(this.j);
            C();
            this.i.requestFocus();
            this.i.postDelayed(new a(this), 150L);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08aa, (ViewGroup) null);
            this.f18546g = linearLayout;
            this.n = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0924b3);
            this.o = (TextView) this.f18546g.findViewById(R.id.obfuscated_res_0x7f092436);
            this.p = (TextView) this.f18546g.findViewById(R.id.obfuscated_res_0x7f092435);
            this.q = (TextView) this.f18546g.findViewById(R.id.obfuscated_res_0x7f0924b2);
            this.r = (TextView) this.f18546g.findViewById(R.id.obfuscated_res_0x7f092432);
            this.s = (TextView) this.f18546g.findViewById(R.id.obfuscated_res_0x7f09242f);
            this.t = (TextView) this.f18546g.findViewById(R.id.obfuscated_res_0x7f092431);
            this.u = (TextView) this.f18546g.findViewById(R.id.obfuscated_res_0x7f092430);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08ab, (ViewGroup) null);
            this.f18545f = linearLayout;
            this.f18547h = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092423);
            this.i = (EditText) this.f18545f.findViewById(R.id.obfuscated_res_0x7f092434);
        }
    }
}
