package c.a.r0.l2.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f22099a;

    /* renamed from: b  reason: collision with root package name */
    public int f22100b;

    /* renamed from: c  reason: collision with root package name */
    public List<b> f22101c;

    /* renamed from: d  reason: collision with root package name */
    public String f22102d;

    /* renamed from: e  reason: collision with root package name */
    public String f22103e;

    /* renamed from: f  reason: collision with root package name */
    public String f22104f;

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
            }
        }
    }

    public void a(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbBookrack) == null) || tbBookrack == null) {
            return;
        }
        this.f22099a = tbBookrack.booktown;
        this.f22100b = tbBookrack.num.intValue();
        this.f22102d = tbBookrack.title;
        this.f22103e = tbBookrack.icon;
        this.f22104f = tbBookrack.tip;
        this.f22101c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    b bVar = new b();
                    bVar.a(bookInfo);
                    this.f22101c.add(bVar);
                }
            }
        }
    }
}
