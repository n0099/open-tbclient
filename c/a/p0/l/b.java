package c.a.p0.l;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.o0.r.r.v0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackReasonCheckBox;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f15977b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<String> f15978c;

    /* renamed from: d  reason: collision with root package name */
    public SparseArray<String> f15979d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f15980e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f15981f;

    /* renamed from: g  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f15982g;

    /* renamed from: h  reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f15983h;
    public HashMap<NEGFeedBackReasonCheckBox, Boolean> i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;

    /* loaded from: classes2.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
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

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Map.Entry entry;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) || compoundButton == null || this.a.i == null || this.a.i.isEmpty()) {
                return;
            }
            boolean z2 = false;
            if (z && this.a.k) {
                for (Map.Entry entry2 : this.a.i.entrySet()) {
                    if (entry2 != null) {
                        if (entry2.getKey() == compoundButton) {
                            ((NEGFeedBackReasonCheckBox) entry2.getKey()).setChecked(true);
                            entry2.setValue(Boolean.TRUE);
                        } else {
                            ((NEGFeedBackReasonCheckBox) entry2.getKey()).setChecked(false);
                            entry2.setValue(Boolean.FALSE);
                        }
                    }
                }
            }
            if (this.a.k && !z && !this.a.l) {
                Iterator it = this.a.i.entrySet().iterator();
                while (it.hasNext() && ((entry = (Map.Entry) it.next()) == null || entry.getKey() == null || !(z2 = ((NEGFeedBackReasonCheckBox) entry.getKey()).isChecked()))) {
                }
                if (!z2) {
                    for (Map.Entry entry3 : this.a.i.entrySet()) {
                        if (entry3 != null && entry3.getKey() == compoundButton) {
                            ((NEGFeedBackReasonCheckBox) entry3.getKey()).setChecked(true);
                            entry3.setValue(Boolean.TRUE);
                            return;
                        }
                    }
                }
            }
            if (this.a.f15982g != null) {
                this.a.f15982g.onCheckedChanged(compoundButton, z);
            }
        }
    }

    /* renamed from: c.a.p0.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1197b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f15984b;

        /* renamed from: c  reason: collision with root package name */
        public String f15985c;

        /* renamed from: d  reason: collision with root package name */
        public String f15986d;

        public C1197b(b bVar, int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i), Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15984b = i2;
            if (str != null && str.contains("%")) {
                String[] split = str.split("%");
                this.f15985c = split[0];
                if (split.length > 1) {
                    this.f15986d = split[1];
                }
            } else {
                this.f15985c = str;
            }
            this.a = i;
        }
    }

    public b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f15978c = null;
        this.f15979d = null;
        this.k = false;
        this.l = true;
        this.m = -1;
        this.f15977b = tbPageContext;
        this.j = n.f(tbPageContext.getPageActivity(), R.dimen.M_H_X003);
        this.f15983h = new a(this);
    }

    public final View e(List<C1197b> list, boolean z, View view) {
        InterceptResult invokeCommon;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{list, Boolean.valueOf(z), view})) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            if (view instanceof LinearLayout) {
                linearLayout = (LinearLayout) view;
            } else {
                linearLayout = (LinearLayout) LayoutInflater.from(this.f15977b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05ed, (ViewGroup) this.f15981f, false);
            }
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.obfuscated_res_0x7f091225);
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.obfuscated_res_0x7f091ab5);
            nEGFeedBackReasonCheckBox.a();
            nEGFeedBackReasonCheckBox2.a();
            nEGFeedBackReasonCheckBox.setChecked(false);
            nEGFeedBackReasonCheckBox2.setChecked(false);
            this.i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
            this.i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
            C1197b c1197b = list.get(0);
            if (c1197b != null) {
                nEGFeedBackReasonCheckBox.setText(c1197b.f15985c);
                nEGFeedBackReasonCheckBox.setTag(c1197b);
                if (c1197b.a == this.m) {
                    nEGFeedBackReasonCheckBox.setEnabled(false);
                }
            }
            if (list.size() > 1 && list.get(1) != null) {
                C1197b c1197b2 = list.get(1);
                nEGFeedBackReasonCheckBox2.setText(c1197b2.f15985c);
                nEGFeedBackReasonCheckBox2.setVisibility(0);
                nEGFeedBackReasonCheckBox2.setTag(c1197b2);
                if (c1197b2.a == this.m) {
                    nEGFeedBackReasonCheckBox2.setEnabled(false);
                }
            } else {
                nEGFeedBackReasonCheckBox2.setVisibility(4);
            }
            nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f15983h);
            nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f15983h);
            int i = z ? 0 : this.j;
            if (linearLayout.getLayoutParams() != null) {
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            }
            return linearLayout;
        }
        return (View) invokeCommon.objValue;
    }

    public final View f(List<C1197b> list, boolean z, View view) {
        InterceptResult invokeCommon;
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, Boolean.valueOf(z), view})) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            if (view instanceof LinearLayout) {
                linearLayout = (LinearLayout) view;
            } else {
                linearLayout = (LinearLayout) LayoutInflater.from(this.f15977b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05ed, (ViewGroup) this.f15981f, false);
            }
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.obfuscated_res_0x7f091225);
            NEGFeedBackReasonCheckBox nEGFeedBackReasonCheckBox2 = (NEGFeedBackReasonCheckBox) linearLayout.findViewById(R.id.obfuscated_res_0x7f091ab5);
            nEGFeedBackReasonCheckBox.a();
            nEGFeedBackReasonCheckBox2.a();
            nEGFeedBackReasonCheckBox.setChecked(false);
            nEGFeedBackReasonCheckBox2.setChecked(false);
            this.i.put(nEGFeedBackReasonCheckBox, Boolean.FALSE);
            this.i.put(nEGFeedBackReasonCheckBox2, Boolean.FALSE);
            C1197b c1197b = list.get(0);
            if (c1197b != null) {
                nEGFeedBackReasonCheckBox.setText(c1197b.f15985c);
                nEGFeedBackReasonCheckBox.setTag(c1197b);
            }
            if (list.size() > 1 && list.get(1) != null) {
                C1197b c1197b2 = list.get(1);
                nEGFeedBackReasonCheckBox2.setText(c1197b2.f15985c);
                nEGFeedBackReasonCheckBox2.setVisibility(0);
                nEGFeedBackReasonCheckBox2.setTag(c1197b2);
            } else {
                nEGFeedBackReasonCheckBox2.setVisibility(8);
            }
            nEGFeedBackReasonCheckBox.setOnCheckedChangeListener(this.f15983h);
            nEGFeedBackReasonCheckBox2.setOnCheckedChangeListener(this.f15983h);
            int i = z ? 0 : this.j;
            if (linearLayout.getLayoutParams() != null) {
                ((ViewGroup.MarginLayoutParams) linearLayout.getLayoutParams()).bottomMargin = i;
            }
            return linearLayout;
        }
        return (View) invokeCommon.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f15981f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f15977b.getPageActivity());
                this.f15981f = linearLayout;
                linearLayout.setOrientation(1);
            }
            List<List<C1197b>> p = p();
            if (ListUtils.isEmpty(p)) {
                return null;
            }
            int size = p.size();
            HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.i;
            if (hashMap == null) {
                this.i = new HashMap<>();
            } else {
                hashMap.clear();
            }
            int i = 0;
            while (i < size) {
                View e2 = e(p.get(i), i == size + (-1), this.f15981f.getChildAt(i));
                if (e2 != null && e2.getParent() == null) {
                    this.f15981f.addView(e2);
                }
                i++;
            }
            if (this.f15981f.getChildCount() > size) {
                LinearLayout linearLayout2 = this.f15981f;
                linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
            }
            return this.f15981f;
        }
        return (View) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f15981f == null) {
                LinearLayout linearLayout = new LinearLayout(this.f15977b.getPageActivity());
                this.f15981f = linearLayout;
                linearLayout.setOrientation(1);
            }
            List<List<C1197b>> s = s();
            if (ListUtils.isEmpty(s)) {
                return null;
            }
            int size = s.size();
            HashMap<NEGFeedBackReasonCheckBox, Boolean> hashMap = this.i;
            if (hashMap == null) {
                this.i = new HashMap<>();
            } else {
                hashMap.clear();
            }
            int i = 0;
            while (i < size) {
                View f2 = f(s.get(i), i == size + (-1), this.f15981f.getChildAt(i));
                if (f2 != null && f2.getParent() == null) {
                    this.f15981f.addView(f2);
                }
                i++;
            }
            if (this.f15981f.getChildCount() > size) {
                LinearLayout linearLayout2 = this.f15981f;
                linearLayout2.removeViews(size, linearLayout2.getChildCount() - size);
            }
            return this.f15981f;
        }
        return (View) invokeV.objValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.l = z;
        }
    }

    public void j(v0 v0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, v0Var) == null) || v0Var == null) {
            return;
        }
        this.f15978c = v0Var.b();
        this.f15979d = v0Var.f10967g;
    }

    public void k(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, strArr) == null) {
            this.f15980e = strArr;
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }

    public void o(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onCheckedChangeListener) == null) {
            this.f15982g = onCheckedChangeListener;
        }
    }

    public final List<List<C1197b>> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            SparseArray<String> sparseArray = this.f15978c;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.f15978c.size();
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < size) {
                    int i2 = i + 1;
                    int i3 = i + 2;
                    ArrayList arrayList2 = new ArrayList();
                    C1197b c1197b = new C1197b(this, i, this.f15978c.keyAt(i), this.f15978c.valueAt(i));
                    SparseArray<String> sparseArray2 = this.f15979d;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f15978c.keyAt(i)))) {
                        c1197b.f15986d = this.f15979d.get(this.f15978c.keyAt(i));
                    }
                    arrayList2.add(c1197b);
                    if (i2 > i && i2 < size) {
                        C1197b c1197b2 = new C1197b(this, i2, this.f15978c.keyAt(i2), this.f15978c.valueAt(i2));
                        SparseArray<String> sparseArray3 = this.f15979d;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f15978c.keyAt(i)))) {
                            c1197b2.f15986d = this.f15979d.get(this.f15978c.keyAt(i2));
                        }
                        arrayList2.add(c1197b2);
                    }
                    arrayList.add(arrayList2);
                    i = i3;
                }
                return arrayList;
            }
            return q();
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C1197b>> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String[] strArr = this.f15980e;
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f15980e.length; i += 2) {
                ArrayList arrayList2 = new ArrayList();
                if (!StringUtils.isNull(this.f15980e[i])) {
                    arrayList2.add(new C1197b(this, i, i + 1, this.f15980e[i]));
                }
                int i2 = i + 1;
                String[] strArr2 = this.f15980e;
                if (i2 < strArr2.length && !StringUtils.isNull(strArr2[i2])) {
                    arrayList2.add(new C1197b(this, i2, i + 2, this.f15980e[i2]));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C1197b>> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String[] strArr = this.f15980e;
            if (strArr == null || strArr.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f15980e.length; i += 2) {
                ArrayList arrayList2 = new ArrayList();
                if (!StringUtils.isNull(this.f15980e[i])) {
                    arrayList2.add(new C1197b(this, i, 0, this.f15980e[i]));
                }
                int i2 = i + 1;
                String[] strArr2 = this.f15980e;
                if (i2 < strArr2.length && !StringUtils.isNull(strArr2[i2])) {
                    arrayList2.add(new C1197b(this, i2, 0, this.f15980e[i2]));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(arrayList2);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final List<List<C1197b>> s() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SparseArray<String> sparseArray = this.f15978c;
            if (sparseArray != null && sparseArray.size() != 0) {
                int size = this.f15978c.size();
                int i3 = 0;
                int i4 = -1;
                int i5 = this.a ? 0 : -1;
                int i6 = this.a ? size - 1 : size;
                if (i6 > 1 && i6 % 2 == 1) {
                    i4 = i5 + 1;
                }
                ArrayList arrayList = new ArrayList();
                while (i3 < size) {
                    if (i3 == i5 || i3 == i4) {
                        i = i3 + 1;
                        i2 = i3;
                    } else {
                        i2 = i3 + 1;
                        i = i3 + 2;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    C1197b c1197b = new C1197b(this, i3, this.f15978c.keyAt(i3), this.f15978c.valueAt(i3));
                    SparseArray<String> sparseArray2 = this.f15979d;
                    if (sparseArray2 != null && !StringUtils.isNull(sparseArray2.get(this.f15978c.keyAt(i3)))) {
                        c1197b.f15986d = this.f15979d.get(this.f15978c.keyAt(i3));
                    }
                    arrayList2.add(c1197b);
                    if (i2 > i3 && i2 < size) {
                        C1197b c1197b2 = new C1197b(this, i2, this.f15978c.keyAt(i2), this.f15978c.valueAt(i2));
                        SparseArray<String> sparseArray3 = this.f15979d;
                        if (sparseArray3 != null && !StringUtils.isNull(sparseArray3.get(this.f15978c.keyAt(i3)))) {
                            c1197b2.f15986d = this.f15979d.get(this.f15978c.keyAt(i2));
                        }
                        arrayList2.add(c1197b2);
                    }
                    arrayList.add(arrayList2);
                    i3 = i;
                }
                return arrayList;
            }
            return r();
        }
        return (List) invokeV.objValue;
    }
}
