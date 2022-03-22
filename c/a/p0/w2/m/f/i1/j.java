package c.a.p0.w2.m.f.i1;

import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.o.e.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.w2.m.c.b f20126b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.s0.a f20127c;

    /* renamed from: d  reason: collision with root package name */
    public View.OnTouchListener f20128d;

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.a.f20127c != null) {
                    this.a.f20127c.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends c.a.o0.e1.n.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.h0.e0.b f20129h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, int i, String str, c.a.p0.h0.e0.b bVar) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i), str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20129h = bVar;
        }

        @Override // c.a.o0.e1.n.f, android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view.getContext(), d(), null)));
                c.a.p0.h0.e0.b bVar = this.f20129h;
                if (bVar instanceof c.a.p0.h0.e0.k) {
                    statisticItem = ((c.a.p0.h0.e0.k) bVar).S();
                } else if (bVar instanceof c.a.p0.h0.e0.l) {
                    statisticItem = ((c.a.p0.h0.e0.l) bVar).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public j(BdTypeRecyclerView bdTypeRecyclerView, c.a.p0.w2.m.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeRecyclerView, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.f20128d = aVar;
        this.a = bdTypeRecyclerView;
        this.f20126b = bVar;
        bdTypeRecyclerView.setOnTouchListener(aVar);
        this.f20127c = new c.a.p0.s0.a();
    }

    public final void b(List<ThreadInfo> list, List<n> list2, String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, list, list2, str) == null) {
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                ThreadInfo threadInfo = list.get(i2);
                if (threadInfo != null) {
                    ThreadData threadData2 = new ThreadData();
                    threadData2.floorNum = i2 + 1;
                    threadData2.parserProtobuf(threadInfo);
                    if (threadData2.getForumData() != null) {
                        threadData2.getForumData().j = str;
                    }
                    if ((c.a.p0.h0.e0.k.W(threadData2) || c.a.p0.h0.e0.l.R(threadData2)) && threadData2.getType() != ThreadData.TYPE_SHARE_THREAD) {
                        c.a.p0.h0.e0.k d2 = d(threadData2);
                        if (d2 != null && (threadData = d2.a) != null && threadData.getForumData() != null && !StringUtils.isNull(threadData.getForumData().f10991b)) {
                            d2.f15321g = threadData2.getTid();
                            d2.position = i;
                            f(d2);
                            list2.add(d2);
                        }
                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                        c.a.p0.h0.e0.b c2 = c(threadData2);
                        if (c2 != null) {
                            c2.f15321g = threadData2.getTid();
                            c2.position = i;
                            if (c2 instanceof c.a.p0.h0.e0.k) {
                                if (threadData2.picCount() == 1) {
                                    h(c2);
                                    c2.j = imageWidthAndHeight[0];
                                    c2.k = imageWidthAndHeight[1];
                                } else if (threadData2.picCount() >= 2) {
                                    g(c2);
                                } else {
                                    i(c2);
                                }
                            } else if (c2 instanceof c.a.p0.h0.e0.l) {
                                j(c2);
                            }
                        }
                        if (c2 != null && c2.isValid()) {
                            c2.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null) {
                                String format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f029a), threadData2.getAuthor().getName_show());
                                SpannableString spannableString = new SpannableString(format);
                                spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), c2), 0, format.length() - 1, 33);
                                c2.a.insertUsernameIntoTitleOrAbstract(spannableString);
                            }
                            list2.add(c2);
                        }
                        c.a.p0.h0.e0.k d3 = d(threadData2);
                        if (d3 != null) {
                            d3.f15321g = threadData2.getTid();
                            d3.position = i;
                            e(d3);
                        }
                        if (d3 != null && d3.isValid()) {
                            list2.add(d3);
                        }
                    }
                    i++;
                }
            }
        }
    }

    public final c.a.p0.h0.e0.b c(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (c.a.p0.h0.e0.k.W(threadData)) {
                c.a.p0.h0.e0.k kVar = new c.a.p0.h0.e0.k();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                kVar.a = threadData;
                return kVar;
            } else if (c.a.p0.h0.e0.l.R(threadData)) {
                return new c.a.p0.h0.e0.l(threadData);
            } else {
                return null;
            }
        }
        return (c.a.p0.h0.e0.b) invokeL.objValue;
    }

    public final c.a.p0.h0.e0.k d(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            c.a.p0.h0.e0.k kVar = new c.a.p0.h0.e0.k();
            kVar.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            return kVar;
        }
        return (c.a.p0.h0.e0.k) invokeL.objValue;
    }

    public final void e(c.a.p0.h0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (bVar instanceof c.a.p0.h0.e0.k) {
                ((c.a.p0.h0.e0.k) bVar).A = true;
            } else if (bVar instanceof c.a.p0.h0.e0.l) {
                ((c.a.p0.h0.e0.l) bVar).A = true;
            } else if (bVar instanceof c.a.p0.h0.e0.j) {
                ((c.a.p0.h0.e0.j) bVar).A = true;
            }
            bVar.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public final void f(c.a.p0.h0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            bVar.n = true;
            bVar.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public final void g(c.a.p0.h0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            ((c.a.p0.h0.e0.k) bVar).q = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void h(c.a.p0.h0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            ((c.a.p0.h0.e0.k) bVar).p = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void i(c.a.p0.h0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            ((c.a.p0.h0.e0.k) bVar).r = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public final void j(c.a.p0.h0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            ((c.a.p0.h0.e0.l) bVar).s = true;
            bVar.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public void k(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        String first_class = fVar.l() != null ? fVar.l().getFirst_class() : "";
        List<ThreadInfo> I = fVar.I();
        LinkedList linkedList = new LinkedList();
        b(I, linkedList, first_class);
        this.f20126b.h(linkedList);
    }
}
