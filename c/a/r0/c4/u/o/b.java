package c.a.r0.c4.u.o;

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
import c.a.e.e.p.l;
import c.a.q0.d1.n0;
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
/* loaded from: classes3.dex */
public class b implements c.a.q0.x0.a, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public Intent E;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<WriteVoteActivity> f17029e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f17030f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f17031g;

    /* renamed from: h  reason: collision with root package name */
    public BdRecyclerView f17032h;

    /* renamed from: i  reason: collision with root package name */
    public WriteVoteViewAdapter f17033i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f17034j;
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

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17035e;

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
            this.f17035e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.K(this.f17035e.f17029e.getPageActivity(), this.f17035e.m);
            }
        }
    }

    /* renamed from: c.a.r0.c4.u.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0818b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17036e;

        public C0818b(b bVar) {
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
            this.f17036e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null) {
                return;
            }
            String obj = editable.toString();
            if (StringUtils.isNull(obj)) {
                this.f17036e.m.setTypeface(Typeface.defaultFromStyle(0));
                this.f17036e.C = false;
                this.f17036e.N(false);
                return;
            }
            String replace = obj.replace(" ", "");
            if (n0.d(replace) > 40) {
                this.f17036e.f17029e.showToast(String.format(this.f17036e.f17029e.getString(R.string.write_vote_toast), 20));
            }
            String m = n0.m(replace, 40);
            if (!m.equals(editable.toString())) {
                this.f17036e.m.setText(m);
                this.f17036e.m.setSelection(m.length());
            }
            this.f17036e.m.setTypeface(Typeface.defaultFromStyle(1));
            this.f17036e.C = true;
            b bVar = this.f17036e;
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

    /* loaded from: classes3.dex */
    public class c implements WriteVoteViewAdapter.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17037a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f17038e;

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
                this.f17038e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17038e.f17037a.f17033i.setData(this.f17038e.f17037a.n);
                }
            }
        }

        /* renamed from: c.a.r0.c4.u.o.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0819b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f17039e;

            public RunnableC0819b(c cVar) {
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
                this.f17039e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17039e.f17037a.f17033i.setData(this.f17039e.f17037a.n);
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
            this.f17037a = bVar;
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f17037a.n.remove(i2);
                this.f17037a.f17032h.post(new RunnableC0819b(this));
                b bVar = this.f17037a;
                bVar.D = bVar.v();
                b bVar2 = this.f17037a;
                bVar2.N(bVar2.C && this.f17037a.D);
            }
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f17037a.n.add(new WriteVoteItemData());
                this.f17037a.f17032h.post(new a(this));
                b bVar = this.f17037a;
                bVar.D = bVar.v();
                b bVar2 = this.f17037a;
                bVar2.N(bVar2.C && this.f17037a.D);
            }
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void c(WriteVoteItemData writeVoteItemData, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, writeVoteItemData, i2) == null) {
                this.f17037a.n.set(i2, writeVoteItemData);
                b bVar = this.f17037a;
                bVar.D = bVar.v();
                b bVar2 = this.f17037a;
                bVar2.N(bVar2.C && this.f17037a.D);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f17040a;

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
            this.f17040a = bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 1 || i2 == 2) {
                    l.x(this.f17040a.f17029e.getPageActivity(), recyclerView);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17041e;

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
            this.f17041e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                List<WriteVoteItemData> u = this.f17041e.u();
                HashMap hashMap = new HashMap();
                int size = u.size();
                for (int i2 = 0; i2 < size; i2++) {
                    WriteVoteItemData writeVoteItemData = u.get(i2);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        this.f17041e.f17029e.showToast(String.format(this.f17041e.f17029e.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i2 + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i2));
                }
                this.f17041e.o = new WriteVoteData();
                this.f17041e.o.setTitle(this.f17041e.m.getText().toString());
                this.f17041e.o.setExpire_type(this.f17041e.B);
                this.f17041e.o.setIs_multi(this.f17041e.A);
                this.f17041e.o.setOptions(u);
                this.f17041e.E = new Intent();
                this.f17041e.E.putExtra(IntentConfig.WRITE_VOTE_DATA, this.f17041e.o);
                this.f17041e.f17029e.getPageActivity().finish();
                b bVar = this.f17041e;
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
        this.f17029e = tbPageContext;
        this.f17030f = linearLayout;
        this.f17031g = navigationBar;
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
            this.f17031g.setCenterTextTitle(this.f17029e.getResources().getString(R.string.write_add_vote));
            TextView addTextButton = this.f17031g.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f17029e.getResources().getString(R.string.done));
            this.z = addTextButton;
            addTextButton.setTextSize(0, l.g(this.f17029e.getPageActivity(), R.dimen.tbds44));
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
        L();
        K();
        boolean v = v();
        this.D = v;
        N(this.C && v);
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || this.p == null || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.f17029e.getPageActivity()).setType(9).setForumWriteData(this.p).setShowVoteData(this.o).setTitle(str).send();
    }

    public final void J(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, textView, z) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.f17029e.getResources().getDimension(R.dimen.tbds10));
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

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            J(this.v, this.B == -1);
            J(this.w, this.B == 1);
            J(this.x, this.B == 7);
            J(this.y, this.B == 30);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            J(this.s, this.A != 1);
            J(this.t, this.A == 1);
        }
    }

    public final void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.z.setEnabled(z);
            if (z) {
                this.z.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            } else {
                this.z.setTextColor(c.a.r0.j3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
            }
        }
    }

    @Override // c.a.q0.x0.a
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.E : (Intent) invokeV.objValue;
    }

    @Override // c.a.q0.x0.a
    public boolean isOnViewCancel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.q0.x0.a
    public boolean isOnViewTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LinearLayout linearLayout = this.f17034j;
            return linearLayout != null && this.f17032h != null && linearLayout.getTop() == 0 && this.f17032h.getFirstVisiblePosition() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            if (view.getId() == R.id.vote_type_single) {
                this.A = 0;
                L();
            } else if (view.getId() == R.id.vote_type_multiple) {
                this.A = 1;
                L();
            } else if (view.getId() == R.id.vote_time_forever) {
                this.B = -1;
                K();
            } else if (view.getId() == R.id.vote_time_1_day) {
                this.B = 1;
                K();
            } else if (view.getId() == R.id.vote_time_7_days) {
                this.B = 7;
                K();
            } else if (view.getId() == R.id.vote_time_30_days) {
                this.B = 30;
                K();
            }
        }
    }

    @Override // c.a.q0.x0.a
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
                this.z.setTextColor(c.a.r0.j3.c.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
            }
            L();
            K();
            WriteVoteViewAdapter writeVoteViewAdapter = this.f17033i;
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
            BdRecyclerView bdRecyclerView = new BdRecyclerView(this.f17029e.getPageActivity());
            this.f17032h = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.f17029e.getPageActivity()));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = l.g(this.f17029e.getPageActivity(), R.dimen.tbds27);
            this.f17030f.addView(this.f17032h, layoutParams);
            WriteVoteViewAdapter writeVoteViewAdapter = new WriteVoteViewAdapter(this.f17029e);
            this.f17033i = writeVoteViewAdapter;
            this.f17032h.setAdapter(writeVoteViewAdapter);
            A();
            y();
            x();
            z();
            this.f17032h.addHeaderView(this.f17034j);
            this.f17032h.addFooterView(this.k);
            this.f17033i.setData(this.n);
            B();
            this.m.requestFocus();
            this.m.postDelayed(new a(this), 150L);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f17029e.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
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
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f17029e.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
            this.f17034j = linearLayout;
            this.l = (TextView) linearLayout.findViewById(R.id.vote_item_tip);
            this.m = (EditText) this.f17034j.findViewById(R.id.vote_title);
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
            this.m.addTextChangedListener(new C0818b(this));
            this.f17033i.setOnVoteItemListener(new c(this));
            this.f17032h.addOnScrollListener(new d(this));
            this.z.setOnClickListener(new e(this));
        }
    }
}
