package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.dl1;
import com.baidu.tieba.fl1;
/* loaded from: classes4.dex */
public class ExceptionHandlerComponent {
    @Inject
    public fl1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        dl1 b = dl1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
