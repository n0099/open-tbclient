package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import com.baidu.pyramid.annotation.Inject;
import com.baidu.tieba.uj1;
import com.baidu.tieba.wj1;
/* loaded from: classes3.dex */
public class ExceptionHandlerComponent {
    @Inject
    public wj1<IExceptionHandlerContext> exceptionHandlerContext;

    public void initexceptionHandlerContext() {
        uj1 b = uj1.b();
        this.exceptionHandlerContext = b;
        b.a(new IExceptionHandlerContext_ExceptionHandlerComponent_Provider());
    }

    public ExceptionHandlerComponent() {
        initexceptionHandlerContext();
    }
}
