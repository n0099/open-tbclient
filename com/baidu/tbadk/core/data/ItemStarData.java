package com.baidu.tbadk.core.data;

import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.HeadItem;
/* loaded from: classes4.dex */
public class ItemStarData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<SingleItemStar> list;

    /* loaded from: classes4.dex */
    public class SingleItemStar implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public String name;
        public final /* synthetic */ ItemStarData this$0;
        public int type;

        public SingleItemStar(ItemStarData itemStarData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemStarData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = itemStarData;
        }

        public void parseProto(HeadItem headItem) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, headItem) == null) || headItem == null) {
                return;
            }
            this.name = headItem.name;
            this.content = headItem.content;
            this.type = headItem.type.intValue();
        }
    }

    public ItemStarData() {
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

    public void parseProto(List<HeadItem> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || ListUtils.getCount(list) == 0) {
            return;
        }
        this.list = new ArrayList();
        for (HeadItem headItem : list) {
            if (headItem != null) {
                SingleItemStar singleItemStar = new SingleItemStar(this);
                singleItemStar.parseProto(headItem);
                this.list.add(singleItemStar);
            }
        }
    }
}
