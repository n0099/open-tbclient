package com.baidu.android.nebula.c;

import com.baidu.android.common.logging.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class b {
    private int b;
    private f c;
    private e d;
    private ExecutorService e;
    private Selector f;
    private ServerSocketChannel g;

    /* renamed from: a  reason: collision with root package name */
    private boolean f276a = false;
    private Thread h = null;

    public b(f fVar, e eVar) {
        this.e = null;
        this.c = fVar;
        this.d = eVar;
        this.e = Executors.newFixedThreadPool(5, new com.baidu.android.moplus.util.a("HttpThreadPool"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int read;
        ByteBuffer allocate = ByteBuffer.allocate(200);
        do {
            this.f.select();
            Iterator<SelectionKey> it = this.f.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                try {
                    if (next.isAcceptable()) {
                        SocketChannel accept = ((ServerSocketChannel) next.channel()).accept();
                        accept.configureBlocking(false);
                        SelectionKey register = accept.register(this.f, 5);
                        d a2 = this.c.a();
                        register.attach(a2);
                        this.d.a(a2);
                    }
                } catch (IOException e) {
                    next.cancel();
                    try {
                        next.channel().close();
                    } catch (Exception e2) {
                        Log.e("HttpServer", "Http Connection Close Exception : \r\n", e2);
                    }
                    Log.e("HttpServer", "Http Server Main Exception : \r\n", e);
                }
                if (next.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) next.channel();
                    d dVar = (d) next.attachment();
                    if (dVar.e() || dVar.f()) {
                        dVar.d();
                        socketChannel.close();
                    } else {
                        allocate.clear();
                        int i = 0;
                        while (true) {
                            read = socketChannel.read(allocate);
                            if (read <= 0) {
                                break;
                            }
                            socketChannel.read(allocate);
                            allocate.flip();
                            dVar.a(allocate);
                            i += read;
                            allocate.clear();
                        }
                        if (read == -1) {
                            dVar.d();
                            socketChannel.close();
                        } else if (i != 0) {
                            dVar.g();
                            if (i != 0 && dVar.b()) {
                                a(new a(this.d, dVar));
                                next.interestOps(4);
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (next.isWritable()) {
                    SocketChannel socketChannel2 = (SocketChannel) next.channel();
                    d dVar2 = (d) next.attachment();
                    if (dVar2.e() || dVar2.f()) {
                        dVar2.d();
                        socketChannel2.close();
                    } else {
                        allocate.clear();
                        allocate.rewind();
                        if (dVar2.b(allocate) > 0) {
                            dVar2.g();
                            allocate.flip();
                            socketChannel2.write(allocate);
                            if (dVar2.c()) {
                                dVar2.d();
                                socketChannel2.close();
                            }
                        } else {
                            continue;
                        }
                    }
                }
                if (!this.f276a) {
                    break;
                }
            }
        } while (this.f276a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            if (this.f != null) {
                this.f.close();
                this.f = null;
            }
            if (this.g != null) {
                this.g.close();
                this.g = null;
            }
            if (this.f276a) {
                this.f276a = false;
                a(this.b);
            }
        } catch (Exception e) {
            Log.e("HttpServer", "", e);
        }
    }

    public void a() {
        this.f276a = false;
        if (this.h != null) {
            this.h.interrupt();
        }
    }

    protected void a(Runnable runnable) {
        this.e.submit(runnable);
    }

    public boolean a(int i) {
        this.b = i;
        if (this.f276a) {
            return true;
        }
        try {
            this.g = ServerSocketChannel.open();
            ServerSocket socket = this.g.socket();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.b);
            socket.setReuseAddress(true);
            socket.bind(inetSocketAddress);
            this.g.configureBlocking(false);
            System.setProperty("java.net.preferIPv6Addresses", "false");
            this.f = Selector.open();
            this.g.register(this.f, 16);
            if (this.f == null || !this.f.isOpen()) {
                Log.e("HttpServer", "--- Start LocalServer occurs unknown error!");
                return false;
            }
            this.h = new Thread(new c(this));
            this.h.setName("BdServer");
            this.h.start();
            this.f276a = true;
            return true;
        } catch (IOException e) {
            Log.e("HttpServer", "--- Start LocalServer Fail! \r\n", e);
            return false;
        }
    }

    public boolean b() {
        return this.f276a;
    }
}
