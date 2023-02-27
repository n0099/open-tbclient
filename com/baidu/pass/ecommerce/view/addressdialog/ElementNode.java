package com.baidu.pass.ecommerce.view.addressdialog;

import com.baidu.sapi2.ecommerce.result.AddressBean;
import java.util.List;
/* loaded from: classes2.dex */
public class ElementNode {
    public AddressEntity addressEntity;
    public ElementNode next;
    public ElementNode pre;

    /* loaded from: classes2.dex */
    public static class AddressEntity {
        public List<AddressBean> hotlists;
        public List<AddressBean> list;
        public String selectedId;
        public String selectedName;
        public int selectedPosition;
        public String selectedType;

        public AddressEntity() {
        }

        public AddressEntity(String str, String str2, String str3) {
            this.selectedId = str;
            this.selectedName = str2;
            this.selectedType = str3;
        }

        public AddressEntity(List<AddressBean> list, List<AddressBean> list2) {
            this.list = list;
            this.hotlists = list2;
        }
    }

    public ElementNode(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public static int getPosition(ElementNode elementNode) {
        ElementNode elementNode2 = elementNode.pre;
        if (elementNode2 != null) {
            return getPosition(elementNode2) + 1;
        }
        return 0;
    }

    public static ElementNode moveHeader(ElementNode elementNode) {
        if (elementNode == null) {
            return null;
        }
        while (true) {
            ElementNode elementNode2 = elementNode.pre;
            if (elementNode2 != null) {
                elementNode = elementNode2;
            } else {
                return elementNode;
            }
        }
    }
}
