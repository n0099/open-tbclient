package c.a.p0.n4.i.c;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f a;

    /* renamed from: b  reason: collision with root package name */
    public List<MusicData> f16624b;

    /* renamed from: c  reason: collision with root package name */
    public int f16625c;

    /* renamed from: d  reason: collision with root package name */
    public String f16626d;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public View f16627b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16628c;

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
                }
            }
        }
    }

    public c(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fVar;
    }

    public void a(TextView textView, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, textView, i, str) == null) || i <= 0) {
            return;
        }
        float f2 = n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0702b3);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f2);
        while (textPaint.measureText(str) > i) {
            f2 -= 1.0f;
            textPaint.setTextSize(f2);
        }
        textView.setTextSize(0, f2);
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f16625c : invokeV.intValue;
    }

    public List<MusicData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f16624b : (List) invokeV.objValue;
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f16625c = i;
            notifyDataSetChanged();
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f16626d = str;
            if (TextUtils.isEmpty(str) || this.f16624b == null) {
                return;
            }
            int i = -1;
            for (int i2 = 0; i2 < this.f16624b.size(); i2++) {
                if (str.equals(this.f16624b.get(i2).id)) {
                    i = i2;
                }
            }
            if (i == -1) {
                i = 1;
            }
            this.f16625c = i;
        }
    }

    public void f(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        this.f16624b = list;
        e(this.f16626d);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<MusicData> list = this.f16624b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            List<MusicData> list = this.f16624b;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04a5, (ViewGroup) null);
                aVar = new a(this);
                aVar.a = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f091489);
                aVar.f16628c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09148d);
                aVar.f16627b = view.findViewById(R.id.obfuscated_res_0x7f09148a);
                aVar.a.setDrawerType(1);
                aVar.a.setIsRound(true);
                aVar.a.setDefaultBgResource(R.color.transparent);
                aVar.a.setDefaultResource(R.drawable.obfuscated_res_0x7f080302);
                aVar.a.setBorderWidth(n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070224));
                aVar.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                aVar.a.setConrers(15);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            MusicData musicData = this.f16624b.get(i);
            if (musicData != null) {
                int i2 = musicData.editMusicType;
                if (i2 == 1) {
                    aVar.a.J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080ac2), 24, false);
                } else if (i2 != 2) {
                    aVar.a.J(musicData.img, 10, false);
                } else {
                    aVar.a.J(String.valueOf((int) R.drawable.obfuscated_res_0x7f080aad), 24, false);
                }
                aVar.f16627b.setVisibility(4);
                aVar.f16628c.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                aVar.f16628c.setText(musicData.name);
                a(aVar.f16628c, n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070235), musicData.name);
                if (i == this.f16625c) {
                    aVar.a.setDrawBorder(true);
                } else {
                    aVar.a.setDrawBorder(false);
                }
                if (i == 0) {
                    view.setPadding(n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0702bc), 0, 0);
                } else if (i == this.f16624b.size() - 1) {
                    view.setPadding(n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0702bc), n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f07020f), 0);
                } else {
                    view.setPadding(n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0701f9), n.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0702bc), 0, 0);
                }
                if (this.a.getPageActivity() instanceof BaseActivity) {
                    ((BaseActivity) this.a.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                    ((BaseActivity) this.a.getPageActivity()).getLayoutMode().j(view);
                } else if (this.a.getPageActivity() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.a.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                    ((BaseFragmentActivity) this.a.getPageActivity()).getLayoutMode().j(view);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
