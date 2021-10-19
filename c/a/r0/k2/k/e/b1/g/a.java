package c.a.r0.k2.k.e.b1.g;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.view.EmotionView;
import com.baidu.tieba.pb.pb.main.emotion.view.PbEmotionBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<EmotionImageData> f20111e;

    /* renamed from: f  reason: collision with root package name */
    public int f20112f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionView.c f20113g;

    /* renamed from: h  reason: collision with root package name */
    public PbEmotionBar.i f20114h;

    /* renamed from: i  reason: collision with root package name */
    public Set<String> f20115i;

    /* renamed from: c.a.r0.k2.k.e.b1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0961a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20116e;

        public View$OnClickListenerC0961a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20116e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f20116e.f20114h != null && (view instanceof EmotionView)) {
                EmotionView emotionView = (EmotionView) view;
                this.f20116e.f20114h.b(emotionView.getData(), emotionView.getIsGif());
                TiebaStatic.log("c12176");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f20117e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20117e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20117e.f20114h == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (!ListUtils.isEmpty(this.f20117e.f20111e)) {
                for (EmotionImageData emotionImageData : this.f20117e.f20111e) {
                    if (emotionImageData != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                        arrayList.add(emotionImageData.getThumbUrl());
                    }
                }
            }
            this.f20117e.f20114h.a(null, null, arrayList);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, Void, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f20118a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20118a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Boolean doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                if (this.f20118a.f20115i != null) {
                    for (String str : this.f20118a.f20115i) {
                        if (!TextUtils.isEmpty(str)) {
                            c.a.q0.c0.c.k().h(str);
                        }
                    }
                    return Boolean.TRUE;
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EmotionView f20119a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f20120b;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20115i = new HashSet();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new c(this).execute(new Void[0]);
        }
    }

    public void e(List<EmotionImageData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.f20111e = list;
        }
    }

    public void f(EmotionView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f20113g = cVar;
        }
    }

    public void g(PbEmotionBar.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f20114h = iVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (ListUtils.isEmpty(this.f20111e)) {
                return 0;
            }
            return this.f20111e.size() + 1;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View view2;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                dVar = new d();
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pb_emotion_bar, (ViewGroup) null);
                EmotionView emotionView = (EmotionView) view2.findViewById(R.id.iv_emotion);
                dVar.f20119a = emotionView;
                emotionView.enablePreview();
                dVar.f20119a.setController(this.f20113g);
                dVar.f20119a.setOnClickListener(new View$OnClickListenerC0961a(this));
                TextView textView = (TextView) view2.findViewById(R.id.tv_more);
                dVar.f20120b = textView;
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
                dVar.f20120b.setOnClickListener(new b(this));
                view2.setTag(dVar);
            } else {
                view2 = view;
                dVar = (d) view.getTag();
            }
            if (i2 >= 0) {
                if (i2 < this.f20111e.size()) {
                    dVar.f20119a.getLayoutParams().width = this.f20112f;
                    dVar.f20119a.getLayoutParams().height = this.f20112f;
                    dVar.f20119a.reset();
                    dVar.f20119a.setTag(R.id.iv_emotion, null);
                    EmotionImageData emotionImageData = this.f20111e.get(i2);
                    if (emotionImageData != null) {
                        dVar.f20119a.loadData(emotionImageData);
                        if (this.f20115i != null && !TextUtils.isEmpty(emotionImageData.getThumbUrl())) {
                            Set<String> set = this.f20115i;
                            set.add(emotionImageData.getThumbUrl() + dVar.f20119a.getLoadProcType());
                        }
                    }
                    dVar.f20119a.setVisibility(0);
                    dVar.f20120b.setVisibility(8);
                } else if (i2 == this.f20111e.size()) {
                    dVar.f20120b.getLayoutParams().width = this.f20112f;
                    dVar.f20120b.getLayoutParams().height = this.f20112f;
                    dVar.f20119a.setVisibility(8);
                    dVar.f20120b.setVisibility(0);
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || this.f20112f == i2) {
            return;
        }
        this.f20112f = i2;
        notifyDataSetChanged();
    }
}
