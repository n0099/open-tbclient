package com.baidu.tbadk;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ TbadkApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbadkApplication tbadkApplication, int i) {
        super(i);
        this.a = tbadkApplication;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Integer num;
        if (customResponsedMessage != null && (num = (Integer) customResponsedMessage.getData()) != null) {
            if (num.intValue() != 0) {
                h.a().b(TbadkApplication.isMem + TbadkApplication.getCurrentAccount(), true);
            } else {
                h.a().b(TbadkApplication.isMem + TbadkApplication.getCurrentAccount(), false);
            }
        }
    }
}
